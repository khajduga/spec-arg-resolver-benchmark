package org.taskforce.benchmarks.params;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.utils.JsonBodyParams;
import net.kaczmarzyk.spring.data.jpa.web.SpecificationFactory;
import net.kaczmarzyk.spring.data.jpa.web.WebRequestProcessingContext;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.springframework.core.MethodParameter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Executable;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.singletonList;
import static org.springframework.web.context.request.RequestAttributes.SCOPE_REQUEST;
import static org.springframework.web.servlet.HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE;

public class WebProcessingContextParametersBenchmark {

	private static final SpecificationFactory SPECIFICATION_FACTORY = new SpecificationFactory(null, null, Locale.getDefault());

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureCreatingSpecWithMultipleParamsUsingWebProcessingContext(Blackhole blackhole) {

		MockWebRequest request = new MockWebRequest("/params");
		request.addParameterValues("age", singletonList("19"));
		request.addParameterValues("city", singletonList("Springfield"));
		request.addParameterValues("criminalPast", singletonList("false"));

		MethodParameter methodParameter = testMethodParameter("multipleParams", MultipleParamsSpecification.class);
		WebRequestProcessingContext context = new WebRequestProcessingContext(methodParameter, request);

		Specification<?> specification = SPECIFICATION_FACTORY.createSpecificationDependingOn(context);
		blackhole.consume(specification);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureCreatingSpecWithMultiplePathVarsUsingWebProcessingContext(Blackhole blackhole) {

		MockWebRequest request = new MockWebRequest("/pathVariables/19/Springfield/false");
		Map<String, String> pathVariables = Map.of(
			"age", "19",
			"city", "Springfield",
			"criminalPast", "false"
		);
		request.setAttribute(URI_TEMPLATE_VARIABLES_ATTRIBUTE, pathVariables, SCOPE_REQUEST);

		MethodParameter methodParameter = testMethodParameter("multiplePathVars", MultiplePathVarsSpecification.class);
		WebRequestProcessingContext context = new WebRequestProcessingContext(methodParameter, request);

		Specification<?> specification = SPECIFICATION_FACTORY.createSpecificationDependingOn(context);
		blackhole.consume(specification);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureCreatingSpecWithMultipleHeadersUsingWebProcessingContext(Blackhole blackhole) {

		MockWebRequest request = new MockWebRequest("/headers");
		request.addHeaderValues("age", singletonList("19"));
		request.addHeaderValues("city", singletonList("Springfield"));
		request.addHeaderValues("criminalPast", singletonList("false"));

		MethodParameter methodParameter = testMethodParameter("multipleHeaders", MultipleHeadersSpecification.class);
		WebRequestProcessingContext context = new WebRequestProcessingContext(methodParameter, request);

		Specification<?> specification = SPECIFICATION_FACTORY.createSpecificationDependingOn(context);
		blackhole.consume(specification);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureCreatingSpecWithMultipleJsonPathsUsingWebProcessingContext(Blackhole blackhole) {

		MockWebRequest request = new MockWebRequest("/jsonPaths");
		MethodParameter methodParameter = testMethodParameter("multipleJsonPaths", MultipleJsonPathsSpecification.class);

		Map<String, String> jsonBody = Map.of(
			"age", "19",
			"city", "Springfield",
			"criminalPast", "false"
		);
		WebRequestProcessingContext context = new WebRequestProcessingContext(methodParameter, request);
		ReflectionTestUtils.setField(context, "bodyParams", JsonBodyParams.parse(serializeMap(jsonBody)));

		Specification<?> specification = SPECIFICATION_FACTORY.createSpecificationDependingOn(context);
		blackhole.consume(specification);
	}

	private MethodParameter testMethodParameter(String methodName, Class<?> specificationType) {
		return MethodParameter.forExecutable(testMethod(methodName, specificationType), 0);
	}

	private Executable testMethod(String methodName, Class<?> specClass) {
		try {
			return BenchmarkController.class.getMethod(methodName, specClass);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String serializeMap(Map<String, String> mapToConversion) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{ ");

		mapToConversion.forEach(
			(key, value) -> stringBuilder
				.append(wrapInDoubleQuotes(key))
				.append(": ")
				.append(wrapInDoubleQuotes(value))
				.append(","));

		// remove last comma
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);

		stringBuilder.append(" }");

		return stringBuilder.toString();
	}

	private String wrapInDoubleQuotes(String value) {
		return "\"" + value + "\"";
	}

	@Or({
		@Spec(path = "age", params = "age", spec = Equal.class),
		@Spec(path = "city", params = "city", spec = Equal.class),
		@Spec(path = "criminalPast", params = "criminalPast", spec = Equal.class),
	})
	private interface MultipleParamsSpecification extends Specification<Object> {
	}

	@Or({
		@Spec(path = "age", pathVars = "age", spec = Equal.class),
		@Spec(path = "city", pathVars = "city", spec = Equal.class),
		@Spec(path = "criminalPast", pathVars = "criminalPast", spec = Equal.class),
	})
	private interface MultiplePathVarsSpecification extends Specification<Object> {
	}

	@Or({
		@Spec(path = "age", headers = "age", spec = Equal.class),
		@Spec(path = "city", headers = "city", spec = Equal.class),
		@Spec(path = "criminalPast", headers = "criminalPast", spec = Equal.class),
	})
	private interface MultipleHeadersSpecification extends Specification<Object> {
	}

	@Or({
		@Spec(path = "age", jsonPaths = "age", spec = Equal.class),
		@Spec(path = "city", jsonPaths = "city", spec = Equal.class),
		@Spec(path = "criminalPast", jsonPaths = "criminalPast", spec = Equal.class),
	})
	private interface MultipleJsonPathsSpecification extends Specification<Object> {
	}

	private static class BenchmarkController {

		@RequestMapping(value = "/params")
		public void multipleParams(MultipleParamsSpecification spec) {
		}

		@RequestMapping(value = "/pathVars/{age}/{city}/{criminalPast}")
		public void multiplePathVars(MultiplePathVarsSpecification spec) {
		}

		@RequestMapping(value = "/headers")
		public void multipleHeaders(MultipleHeadersSpecification spec) {
		}

		@RequestMapping(value = "/jsonPaths")
		public void multipleJsonPaths(MultipleJsonPathsSpecification spec) {
		}
	}
}

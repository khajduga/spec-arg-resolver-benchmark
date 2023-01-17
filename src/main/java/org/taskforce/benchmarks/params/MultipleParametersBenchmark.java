package org.taskforce.benchmarks.params;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.springframework.data.jpa.domain.Specification;

import java.util.concurrent.TimeUnit;

import static net.kaczmarzyk.spring.data.jpa.utils.SpecificationBuilder.specification;

public class MultipleParametersBenchmark {

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithThreeParams(Blackhole blackhole) {
		MultipleParamsSpecification result = specification(MultipleParamsSpecification.class)
			.withParam("firstName", "Bart")
			.withParam("lastName", "Simpson")
			.withParam("age", "19")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithFiveParams(Blackhole blackhole) {
		MultipleParamsSpecification result = specification(MultipleParamsSpecification.class)
			.withParam("firstName", "Bart")
			.withParam("lastName", "Simpson")
			.withParam("age", "19")
			.withParam("gender", "MALE")
			.withParam("hairColor", "yellow")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithTenParams(Blackhole blackhole) {
		MultipleParamsSpecification result = specification(MultipleParamsSpecification.class)
			.withParam("firstName", "Bart")
			.withParam("lastName", "Simpson")
			.withParam("age", "19")
			.withParam("gender", "MALE")
			.withParam("hairColor", "yellow")
			.withParam("iris", "black")
			.withParam("height", "5′9")
			.withParam("motherName", "Marge")
			.withParam("vip", "false")
			.withParam("city", "Springfield")
			.build();

		blackhole.consume(result);
	}


	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithThreePathVariables(Blackhole blackhole) {
		MultiplePathVarsSpecification result = specification(MultiplePathVarsSpecification.class)
			.withPathVar("firstName", "Bart")
			.withPathVar("lastName", "Simpson")
			.withPathVar("age", "19")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithFivePathVariables(Blackhole blackhole) {
		MultiplePathVarsSpecification result = specification(MultiplePathVarsSpecification.class)
			.withPathVar("firstName", "Bart")
			.withPathVar("lastName", "Simpson")
			.withPathVar("age", "19")
			.withPathVar("gender", "MALE")
			.withPathVar("hairColor", "yellow")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithTenPathVariables(Blackhole blackhole) {
		MultiplePathVarsSpecification result = specification(MultiplePathVarsSpecification.class)
			.withPathVar("firstName", "Bart")
			.withPathVar("lastName", "Simpson")
			.withPathVar("age", "19")
			.withPathVar("gender", "MALE")
			.withPathVar("hairColor", "yellow")
			.withPathVar("iris", "black")
			.withPathVar("height", "5′9")
			.withPathVar("motherName", "Marge")
			.withPathVar("vip", "false")
			.withPathVar("city", "Springfield")
			.build();

		blackhole.consume(result);
	}


	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithThreeHeaders(Blackhole blackhole) {
		MultipleHeadersSpecification result = specification(MultipleHeadersSpecification.class)
			.withHeader("firstName", "Bart")
			.withHeader("lastName", "Simpson")
			.withHeader("age", "19")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithFiveHeaders(Blackhole blackhole) {
		MultipleHeadersSpecification result = specification(MultipleHeadersSpecification.class)
			.withHeader("firstName", "Bart")
			.withHeader("lastName", "Simpson")
			.withHeader("age", "19")
			.withHeader("gender", "MALE")
			.withHeader("hairColor", "yellow")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithTenHeaders(Blackhole blackhole) {
		MultipleHeadersSpecification result = specification(MultipleHeadersSpecification.class)
			.withHeader("firstName", "Bart")
			.withHeader("lastName", "Simpson")
			.withHeader("age", "19")
			.withHeader("gender", "MALE")
			.withHeader("hairColor", "yellow")
			.withHeader("iris", "black")
			.withHeader("height", "5′9")
			.withHeader("motherName", "Marge")
			.withHeader("vip", "false")
			.withHeader("city", "Springfield")
			.build();

		blackhole.consume(result);
	}


	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithThreeJsonPaths(Blackhole blackhole) {
		MultipleJsonPathsSpecification result = specification(MultipleJsonPathsSpecification.class)
			.withJsonBodyParam("firstName", "Bart")
			.withJsonBodyParam("lastName", "Simpson")
			.withJsonBodyParam("age", "19")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithFiveJsonPaths(Blackhole blackhole) {
		MultipleJsonPathsSpecification result = specification(MultipleJsonPathsSpecification.class)
			.withJsonBodyParam("firstName", "Bart")
			.withJsonBodyParam("lastName", "Simpson")
			.withJsonBodyParam("age", "19")
			.withJsonBodyParam("gender", "MALE")
			.withJsonBodyParam("hairColor", "yellow")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithTenJsonPaths(Blackhole blackhole) {
		MultipleJsonPathsSpecification result = specification(MultipleJsonPathsSpecification.class)
			.withJsonBodyParam("firstName", "Bart")
			.withJsonBodyParam("lastName", "Simpson")
			.withJsonBodyParam("age", "19")
			.withJsonBodyParam("gender", "MALE")
			.withJsonBodyParam("hairColor", "yellow")
			.withJsonBodyParam("iris", "black")
			.withJsonBodyParam("height", "5′9")
			.withJsonBodyParam("motherName", "Marge")
			.withJsonBodyParam("vip", "false")
			.withJsonBodyParam("city", "Springfield")
			.build();

		blackhole.consume(result);
	}

//	@Benchmark
//	@BenchmarkMode(Mode.AverageTime)
//	@OutputTimeUnit(TimeUnit.NANOSECONDS)
//	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
//	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
//	@Fork(5)
//	public void measureBuildingSpecWithAllAvailableParameters(Blackhole blackhole) {
//		VariousParametersBenchmark.ParametersSpecification result = specification(VariousParametersBenchmark.ParametersSpecification.class)
//			.withParam("firstName", "Bart")
//			.withPathVar("lastName", "Simpson")
//			.withHeader("gender", "MALE")
//			.withJsonBodyParam("money", "$1")
//			.withArg("clothesFrom", "Adidas")
//			.build();
//
//		blackhole.consume(result);
//	}

	@Or({
		@Spec(path = "lastName", params = "lastName", spec = Equal.class),
		@Spec(path = "firstName", params = "firstName", spec = Equal.class),
		@Spec(path = "age", params = "age", spec = Equal.class),
		@Spec(path = "gender", params = "gender", spec = Equal.class),
		@Spec(path = "hairColor", params = "hairColor", spec = Equal.class),
		@Spec(path = "iris", params = "iris", spec = Equal.class),
		@Spec(path = "height", params = "height", spec = Equal.class),
		@Spec(path = "motherName", params = "motherName", spec = Equal.class),
		@Spec(path = "vip", params = "vip", spec = Equal.class),
		@Spec(path = "city", params = "city", spec = Equal.class),
	})
	private interface MultipleParamsSpecification extends Specification<Object> {
	}

	@Or({
		@Spec(path = "lastName", pathVars = "lastName", spec = Equal.class),
		@Spec(path = "firstName", pathVars = "firstName", spec = Equal.class),
		@Spec(path = "age", pathVars = "age", spec = Equal.class),
		@Spec(path = "gender", pathVars = "gender", spec = Equal.class),
		@Spec(path = "hairColor", pathVars = "hairColor", spec = Equal.class),
		@Spec(path = "iris", pathVars = "iris", spec = Equal.class),
		@Spec(path = "height", pathVars = "height", spec = Equal.class),
		@Spec(path = "motherName", pathVars = "motherName", spec = Equal.class),
		@Spec(path = "vip", pathVars = "vip", spec = Equal.class),
		@Spec(path = "city", pathVars = "city", spec = Equal.class),
	})
	private interface MultiplePathVarsSpecification extends Specification<Object> {
	}

	@Or({
		@Spec(path = "lastName", headers = "lastName", spec = Equal.class),
		@Spec(path = "firstName", headers = "firstName", spec = Equal.class),
		@Spec(path = "age", headers = "age", spec = Equal.class),
		@Spec(path = "gender", headers = "gender", spec = Equal.class),
		@Spec(path = "hairColor", headers = "hairColor", spec = Equal.class),
		@Spec(path = "iris", headers = "iris", spec = Equal.class),
		@Spec(path = "height", headers = "height", spec = Equal.class),
		@Spec(path = "motherName", headers = "motherName", spec = Equal.class),
		@Spec(path = "vip", headers = "vip", spec = Equal.class),
		@Spec(path = "city", headers = "city", spec = Equal.class),
	})
	private interface MultipleHeadersSpecification extends Specification<Object> {
	}

	@Or({
		@Spec(path = "lastName", jsonPaths = "lastName", spec = Equal.class),
		@Spec(path = "firstName", jsonPaths = "firstName", spec = Equal.class),
		@Spec(path = "age", jsonPaths = "age", spec = Equal.class),
		@Spec(path = "gender", jsonPaths = "gender", spec = Equal.class),
		@Spec(path = "hairColor", jsonPaths = "hairColor", spec = Equal.class),
		@Spec(path = "iris", jsonPaths = "iris", spec = Equal.class),
		@Spec(path = "height", jsonPaths = "height", spec = Equal.class),
		@Spec(path = "motherName", jsonPaths = "motherName", spec = Equal.class),
		@Spec(path = "vip", jsonPaths = "vip", spec = Equal.class),
		@Spec(path = "city", jsonPaths = "city", spec = Equal.class),
	})
	private interface MultipleJsonPathsSpecification extends Specification<Object> {
	}
}

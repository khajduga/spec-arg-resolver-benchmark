package org.taskforce.benchmarks.params;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.springframework.data.jpa.domain.Specification;

import java.util.concurrent.TimeUnit;

public class MultipleParametersBenchmark extends ParametersBenchmarkBase {

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithThreeParams(Blackhole blackhole) {
		ThreeParamsSpecification result = paramsSpecification(ThreeParamsSpecification.class, 3);

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithThreePathVars(Blackhole blackhole) {
		ThreePathVarsSpecification result = pathVarsSpecification(ThreePathVarsSpecification.class, 3);

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithThreeHeaders(Blackhole blackhole) {
		ThreeHeadersSpecification result = headersSpecification(ThreeHeadersSpecification.class, 3);

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithThreeJsonPaths(Blackhole blackhole) {
		ThreeJsonPathsSpecification result = jsonPathsSpecification(ThreeJsonPathsSpecification.class, 3);

		blackhole.consume(result);
	}

	@Or({
		@Spec(path = "age", params = "age", spec = Equal.class),
		@Spec(path = "city", params = "city", spec = Equal.class),
		@Spec(path = "criminalPast", params = "criminalPast", spec = Equal.class),
	})
	private interface ThreeParamsSpecification extends Specification<Object> {
	}

	@Or({
		@Spec(path = "age", pathVars = "age", spec = Equal.class),
		@Spec(path = "city", pathVars = "city", spec = Equal.class),
		@Spec(path = "criminalPast", pathVars = "criminalPast", spec = Equal.class),
	})
	private interface ThreePathVarsSpecification extends Specification<Object> {
	}

	@Or({
		@Spec(path = "age", headers = "age", spec = Equal.class),
		@Spec(path = "city", headers = "city", spec = Equal.class),
		@Spec(path = "criminalPast", headers = "criminalPast", spec = Equal.class),
	})
	private interface ThreeHeadersSpecification extends Specification<Object> {
	}

	@Or({
		@Spec(path = "age", jsonPaths = "age", spec = Equal.class),
		@Spec(path = "city", jsonPaths = "city", spec = Equal.class),
		@Spec(path = "criminalPast", jsonPaths = "criminalPast", spec = Equal.class),
	})
	private interface ThreeJsonPathsSpecification extends Specification<Object> {
	}
}

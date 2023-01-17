package org.taskforce.benchmarks.params;

import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.springframework.data.jpa.domain.Specification;

import java.util.concurrent.TimeUnit;

import static net.kaczmarzyk.spring.data.jpa.utils.SpecificationBuilder.specification;

public class VariousParametersBenchmark {

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithParam(Blackhole blackhole) {
		ParametersSpecification result = specification(ParametersSpecification.class)
			.withParam("firstName", "Bart")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithHeader(Blackhole blackhole) {
		HeadersSpecification result = specification(HeadersSpecification.class)
			.withHeader("firstName", "Bart")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithPathVariable(Blackhole blackhole) {
		PathVarsSpecification result = specification(PathVarsSpecification.class)
			.withPathVar("firstName", "Bart")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithJsonPath(Blackhole blackhole) {
		JsonPathsSpecification result = specification(JsonPathsSpecification.class)
			.withJsonBodyParam("firstName", "Bart")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithArgParameter(Blackhole blackhole) {
		Specification<?> result = specification(ParametersSpecification.class)
			.withArg("firstName", "Bart")
			.build();

		blackhole.consume(result);
	}

	@Spec(path = "firstName", jsonPaths = "firstName", spec = Like.class)
	private interface ParametersSpecification extends Specification<Object> {
	}

	@Spec(path = "firstName", jsonPaths = "firstName", spec = Like.class)
	private interface PathVarsSpecification extends Specification<Object> {
	}

	@Spec(path = "firstName", jsonPaths = "firstName", spec = Like.class)
	private interface HeadersSpecification extends Specification<Object> {
	}

	@Spec(path = "firstName", jsonPaths = "firstName", spec = Like.class)
	private interface JsonPathsSpecification extends Specification<Object> {
	}

}

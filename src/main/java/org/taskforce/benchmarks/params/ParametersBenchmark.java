package org.taskforce.benchmarks.params;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

import static net.kaczmarzyk.spring.data.jpa.utils.SpecificationBuilder.specification;

public class ParametersBenchmark {

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithParam(Blackhole blackhole) {
		SampleSpecification result = specification(SampleSpecification.class)
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
	public void measureBuildingSpecWithMultipleParams(Blackhole blackhole) {
		SampleSpecification result = specification(SampleSpecification.class)
			.withParam("firstName", "Bart")
			.withParam("lastName", "Simpson")
			.withParam("gender", "MALE")
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
		SampleSpecification result = specification(SampleSpecification.class)
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
	public void measureBuildingSpecWithMultipleHeaders(Blackhole blackhole) {
		SampleSpecification result = specification(SampleSpecification.class)
			.withHeader("firstName", "Bart")
			.withHeader("lastName", "Simpson")
			.withHeader("gender", "MALE")
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
		SampleSpecification result = specification(SampleSpecification.class)
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
	public void measureBuildingSpecWithMultiplePathVariables(Blackhole blackhole) {
		SampleSpecification result = specification(SampleSpecification.class)
			.withPathVar("firstName", "Bart")
			.withPathVar("lastName", "Simpson")
			.withPathVar("gender", "MALE")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithJsonParam(Blackhole blackhole) {
		SampleSpecification result = specification(SampleSpecification.class)
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
	public void measureBuildingSpecWithMultipleJsonParams(Blackhole blackhole) {
		SampleSpecification result = specification(SampleSpecification.class)
			.withJsonBodyParam("firstName", "Bart")
			.withJsonBodyParam("lastName", "Simpson")
			.withJsonBodyParam("gender", "MALE")
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
		SampleSpecification result = specification(SampleSpecification.class)
			.withArg("firstName", "Bart")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithMultipleArgParameters(Blackhole blackhole) {
		SampleSpecification result = specification(SampleSpecification.class)
			.withArg("firstName", "Bart")
			.withArg("lastName", "Simpson")
			.withArg("gender", "MALE")
			.build();

		blackhole.consume(result);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	@Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Measurement(time = 50, timeUnit = TimeUnit.MILLISECONDS, iterations = 10)
	@Fork(5)
	public void measureBuildingSpecWithAllAvailableParameters(Blackhole blackhole) {
		SampleSpecification result = specification(SampleSpecification.class)
			.withParam("firstName", "Bart")
			.withPathVar("lastName", "Simpson")
			.withHeader("gender", "MALE")
			.withJsonBodyParam("money", "$1")
			.withArg("clothesFrom", "Adidas")
			.build();

		blackhole.consume(result);
	}

}

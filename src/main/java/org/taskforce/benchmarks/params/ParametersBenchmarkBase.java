package org.taskforce.benchmarks.params;

import net.kaczmarzyk.spring.data.jpa.utils.SpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;
import static net.kaczmarzyk.spring.data.jpa.utils.SpecificationBuilder.specification;

abstract class ParametersBenchmarkBase {

	// Please remember to also add new parameter to your interface with defined specifications
	private static final SortedMap<String, String> PARAMETERS_WITH_VALUES = new TreeMap<>(ofEntries(
		entry("firstName", "Bart"),
		entry("lastName", "Simpson"),
		entry("age", "19"),
		entry("gender", "MALE"),
		entry("hairColor", "yellow"),
		entry("iris", "black"),
		entry("height", "5′9"),
		entry("race", "simpsonish"),
		entry("motherName", "Marge"),
		entry("fatherName", "Homer"),
		entry("vip", "false"),
		entry("city", "Springfield"),
		entry("criminalPast", "false"),
		entry("religion", "simpsonish"),
		entry("state", "Texas")
	));

	protected <T extends Specification<?>> T paramsSpecification(Class<T> specificationType, int parametersAmount) {

		return specificationWithArguments(
			specificationType,
			(entry, builder) -> builder.withParam(entry.getKey(), entry.getValue()),
			parametersAmount);
	}

	protected <T extends Specification<?>> T pathVarsSpecification(Class<T> specificationType, int pathVarsAmount) {

		return specificationWithArguments(
			specificationType,
			(entry, builder) -> builder.withPathVar(entry.getKey(), entry.getValue()),
			pathVarsAmount);
	}

	protected <T extends Specification<?>> T headersSpecification(Class<T> specificationType, int headersAmount) {

		return specificationWithArguments(
			specificationType,
			(entry, builder) -> builder.withHeader(entry.getKey(), entry.getValue()),
			headersAmount);
	}

	protected <T extends Specification<?>> T jsonPathsSpecification(Class<T> specificationType, int jsonPathsAmount) {

		return specificationWithArguments(
			specificationType,
			(entry, builder) -> builder.withJsonBodyParam(entry.getKey(), entry.getValue()),
			jsonPathsAmount);
	}

	/**
	 *
	 * @param specificationType - type of interface with defined specification
	 * @param argumentsAppender - Consumer that defines the way of passing arguments to SpecificationBuilder (withParam(...) or withHeader(...), etc.)
	 * @param argumentsAmount - amount of argument passed to specification (max 15)
	 * @param <T> - type of the expected Specification
	 * @return Specification of given type with defined arguments.
	 */
	private <T extends Specification<?>> T specificationWithArguments(Class<T> specificationType,
	                                                                  BiConsumer<Map.Entry<String, String>, SpecificationBuilder<T>> argumentsAppender,
	                                                                  int argumentsAmount) {

		SpecificationBuilder<T> specificationBuilder = specification(specificationType);
		Iterator<Map.Entry<String, String>> iterator = PARAMETERS_WITH_VALUES.entrySet().iterator();

		int includedParameters = 0;
		while (iterator.hasNext() && includedParameters < argumentsAmount) {
			Map.Entry<String, String> nextParamWithValue = iterator.next();
			argumentsAppender.accept(nextParamWithValue, specificationBuilder);
			includedParameters++;
		}

		return specificationBuilder.build();
	}
}

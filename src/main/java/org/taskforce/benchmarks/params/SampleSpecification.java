package org.taskforce.benchmarks.params;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Conjunction;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Conjunction(value = {
	@Or({
		@Spec(path = "lastName", jsonPaths = "lastName", spec = Like.class),
		@Spec(path = "firstName", jsonPaths = "firstName", spec = Like.class),
	})},
	and = @Spec(path = "firstName", jsonPaths = "firstName", spec = Equal.class))
public interface SampleSpecification extends Specification<Object> {
}

package solution;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import language.Language;
import person.Person;

public interface Solution {

	void run();

	default void execute(Person p1, Person p2, Person p3, Person p4, Person p5) {
		Set<Language> set = Stream.of(p1, p2, p3, p4, p5).
				flatMap(person -> person.getSpokenLanguages().stream())
				.sorted((e1,e2) -> e1.getName().compareTo(e2.getName()))
				.collect(Collectors.toSet());
		set.forEach(x -> System.out.println(x.getName()));
	}
}

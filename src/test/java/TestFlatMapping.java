import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.stream.Collectors;
import static org.junit.Assert.*;
import org.junit.Test;

import solution.Solution;
import solution.SolutionWithSpring;

public class TestFlatMapping {
	final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	public static void main(String[] args) {
		new TestFlatMapping().testFlatMap();
	}
	
	public void testFlatMap() {
		Solution solution = new SolutionWithSpring();
		Set<String> langs = Set.of("Magyar", "English", "Espanyol", "Deutsch", "Portuguese", "Francais", "Wuhanhua", "Sioux", "Turkce", "Hebrew", "Ancient Greek").stream()
				.sorted((e1, e2) -> e1.compareTo(e2)).collect(Collectors.toSet());
		System.setOut(new PrintStream(outContent));
		solution.run();
		System.out.println(langs.toString());
		System.out.println(outContent.toString());
		assertEquals(langs.toString(), outContent.toString());
	}

}

package language;

import java.util.List;
import java.util.stream.Collectors;

import solution.Obtainer;

public class LanguageObtainer implements Obtainer<Language> {
	private Obtainer<String> obtainer;

	public LanguageObtainer(Obtainer<String> obtainer) {
		this.obtainer = obtainer;
	}

	@Override
	public List<Language> obtain() {
		return obtainer.obtain().stream().map(x -> createLanguage(x)).collect(Collectors.toList());
	}

	private Language createLanguage(String input) {
		Language temp = new Language();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				temp.setName(input.substring(0, i - 1));
				temp.setIsoCode(input.substring(i + 1, input.length() - 2));
			}
		}
		return temp;
	}

}

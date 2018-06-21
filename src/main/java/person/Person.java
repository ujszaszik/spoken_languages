package person;

import java.util.Set;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import language.Language;
import language.LanguageManager;
import person.name.FirstName;
import person.name.LastName;
import person.name.Name;
import person.name.NameManager;
import person.name.NameObtainer;
import person.name.Text;
import solution.Urls;

@Configuration
public class Person {
	private Name name;
	private Set<Language> spokenLanguages;
	private NameManager nameManager = new NameManager();

	public Person() {
	}

	@Autowired
	public Person(Name name, Set<Language> spokenLanguages) {
		this.name = name;
		this.spokenLanguages = spokenLanguages;
	}

	public Person withRandomData() {
		spokenLanguages = new LanguageManager().obtainField();
		Text firstName = initializeName(new NameObtainer(Urls.FIRST_NAME), FirstName.class);
		Text lastName = initializeName(new NameObtainer(Urls.LAST_NAME), LastName.class);
		name = new Name(firstName, lastName);
		return this;
	}

	private Text initializeName(NameObtainer obtainer, Class<? extends Text> c) {
		nameManager.setObtainer(obtainer);
		nameManager.setEntityClass(c);
		return nameManager.obtainField();
	}

	public Name getName() {
		return name;
	}

	public Set<Language> getSpokenLanguages() {
		return spokenLanguages;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setSpokenLanguages(Set<Language> spokenLanguages) {
		this.spokenLanguages = spokenLanguages;
	}

	public void setNameManager(NameManager nameManager) {
		this.nameManager = nameManager;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " (");
		StringJoiner sj = new StringJoiner(", ");
		for (Language l : spokenLanguages) {
			sj.add(l.toString());
		}
		sb.append(sj.toString());
		sb.append(" )");
		return sb.toString();
	}

}

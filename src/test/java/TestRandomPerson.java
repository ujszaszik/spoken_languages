import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import language.Language;
import person.Person;
import solution.ServiceLocator;

public class TestRandomPerson {
	private static final int MAX_LANGUAGE_PER_PERSON = 10;
	Session session = ServiceLocator.getSessionFactory().openSession();

	@Test
	public void testRandomPerson() {
		session.beginTransaction();
		Person p = new Person().withRandomData();
		assertTrue(checkRandomPersonMaxLanguagesSpoken(p));
		assertTrue(isLanguageExisting(p.getSpokenLanguages()));
		assertTrue(isFirstNameExisting(p.getName().getFirstName().getValue()));
		assertTrue(isLastNameExisting(p.getName().getLastName().getValue()));
		session.getTransaction();
		session.close();
	}

	private boolean isLanguageExisting(Set<Language> languages) {
		for (Language l : languages) {
			if (session.createQuery("from Language where name=:language").setParameter("language", l.getName()).uniqueResult() == null) {
				return false;
			}
		}
		return true;
	}

	private boolean isFirstNameExisting(String firstName) {
		return session.createQuery("from FirstName where value=:value").setParameter("value", firstName).uniqueResult() != null;
	}

	private boolean isLastNameExisting(String lastName) {
		return session.createQuery("from LastName where value=:value").setParameter("value", lastName).uniqueResult() != null;
	}

	private boolean checkRandomPersonMaxLanguagesSpoken(Person p) {
		return p.getSpokenLanguages().size() <= MAX_LANGUAGE_PER_PERSON;
	}
}

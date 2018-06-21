package language;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import person.name.NameObtainer;
import solution.Obtainer;
import solution.ServiceLocator;
import solution.SystemDao;
import solution.Urls;

public class LanguageManager implements SystemDao<Set<Language>> {

	@Override
	public void uploadData() {
		Session session = ServiceLocator.getSessionFactory().openSession();
		session.beginTransaction();
		Obtainer<Language> obtainer = new LanguageObtainer(new NameObtainer(Urls.LANGUAGE));
		List<Language> languages = obtainer.obtain();
		for (int i = 0; i < languages.size(); i++) {
			session.save(new Language(i + 1, languages.get(i)));
		}
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Set<Language> obtainField() {
		Session session = ServiceLocator.getSessionFactory().openSession();
		session.beginTransaction();
		Set<Language> langs = new TreeSet<>((e1, e2) -> e1.getName().compareTo(e2.getName()));
		for (int i = 0; i < new Random().nextInt(10); i++) {
			Language lang = (Language) session.get(Language.class, new Random().nextInt(getRowCount()));
			langs.add(lang);
		}
		session.getTransaction().commit();
		session.close();
		return langs;
	}

	@Override
	public Integer getRowCount() {
		Session session = ServiceLocator.getSessionFactory().openSession();
		session.beginTransaction();
		Long rowCount = (Long) session.createCriteria(Language.class).setProjection(Projections.rowCount()).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return rowCount.intValue();
	}

}

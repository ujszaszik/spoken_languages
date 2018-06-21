import static org.junit.Assert.assertEquals;

import org.junit.Test;

import language.LanguageManager;
import person.name.FirstName;
import person.name.LastName;
import person.name.NameManager;
import person.name.NameObtainer;
import person.name.Text;
import solution.SystemDao;
import solution.Urls;

public class TestDataManager {
	private SystemDao<? extends Object> dao;

	@Test
	public void testLanguageRowCount() {
		dao = new LanguageManager();
		assertEquals(609, dao.getRowCount());
	}

	@Test
	public void testFirstNameRowCount() {
		testNameRowCount(Urls.FIRST_NAME, FirstName.class, 4945);
	}

	@Test
	public void testLastNameRowCount() {
		testNameRowCount(Urls.LAST_NAME, LastName.class, 88799);
	}

	private void testNameRowCount(Urls url, Class<? extends Text> c, Number number) {
		NameManager nm = new NameManager();
		nm.setEntityClass(c);
		nm.setObtainer(new NameObtainer(url));
		dao = nm;
		assertEquals(number, dao.getRowCount());
	}

}

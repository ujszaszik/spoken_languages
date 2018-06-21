package person.name;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import solution.ServiceLocator;
import solution.SystemDao;

public class NameManager implements SystemDao<Text> {
	protected NameObtainer obtainer;
	protected Class<? extends Text> entityClass;

	@Override
	public void uploadData() {
		Session session = ServiceLocator.getSessionFactory().openSession();
		session.beginTransaction();
		List<String> names = obtainer.obtain();
		for (int i = 0; i < names.size(); i++) {
			session.save(new FirstName(i + 1, names.get(i)));
		}
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Text obtainField() {
		Session session = ServiceLocator.createSessionFactory().openSession();
		session.beginTransaction();
		Text firstName = (Text) session.get(entityClass, new Random().nextInt(getRowCount()));
		session.close();
		return firstName;
	}

	@Override
	public Integer getRowCount() {
		Session session = ServiceLocator.getSessionFactory().openSession();
		session.beginTransaction();
		Long rowCount = (Long) session.createCriteria(entityClass).setProjection(Projections.rowCount()).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return rowCount.intValue();
	}

	public void setObtainer(NameObtainer obtainer) {
		this.obtainer = obtainer;
	}
	
	public void setEntityClass(Class<? extends Text> entityClass) {
		this.entityClass = entityClass;
	}

}

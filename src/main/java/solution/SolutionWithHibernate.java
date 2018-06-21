package solution;

import person.Person;

public class SolutionWithHibernate implements Solution {

	public void run() {
		Person p1 = new Person().withRandomData();
		Person p2 = new Person().withRandomData();
		Person p3 = new Person().withRandomData();
		Person p4 = new Person().withRandomData();
		Person p5 = new Person().withRandomData();

		execute(p1, p2, p3, p4, p5);
		
		ServiceLocator.shutdown();
	}

}

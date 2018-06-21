package solution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import person.Person;

public class SolutionWithSpring implements Solution {
	private ApplicationContext context;

	@Override
	public void run() {
		context = new ClassPathXmlApplicationContext("spring.xml");

		Person p1 = (Person) context.getBean("person1");
		Person p2 = (Person) context.getBean("person2");
		Person p3 = (Person) context.getBean("person3");
		Person p4 = (Person) context.getBean("person4");
		Person p5 = (Person) context.getBean("person5");

		execute(p1, p2, p3, p4, p5);
		
		((ConfigurableApplicationContext)context).close();
	}

}

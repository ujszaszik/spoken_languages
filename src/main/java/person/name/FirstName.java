package person.name;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("text")
@Transactional
@ComponentScan("person.name")
public class FirstName extends Text {

	public FirstName() {
		super();
	}

	@Autowired
	public FirstName(int id, String value) {
		super(id, value);
	}

}

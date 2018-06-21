package person.name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Name {
	private int id;
	private Text firstName;
	private Text lastName;
	
	public Name() {
		
	}

	@Autowired
	public Name(Text firstName, Text lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Text getFirstName() {
		return firstName;
	}

	public void setFirstName(Text firstName) {
		this.firstName = firstName;
	}

	public Text getLastName() {
		return lastName;
	}

	public void setLastName(Text lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + ", " + lastName;
	}

}

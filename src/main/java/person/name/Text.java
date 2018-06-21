package person.name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
@Qualifier(value="text")
public class Text {
	protected int id;
	protected String value;

	@Autowired
	public Text(int id, String value) {
		this.id = id;
		this.value = value;
	}

	public Text() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
	
	

}

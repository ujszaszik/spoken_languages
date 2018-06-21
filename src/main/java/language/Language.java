package language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class Language {
	private int id;
	private String name;
	private String isoCode;

	public Language() {

	}

	public Language(int id, Language language) {
		this.id = id;
		this.name = language.getName();
		this.isoCode = language.getIsoCode();
	}

	@Autowired
	public Language(int id, String name, String isoCode) {
		this.id = id;
		this.name = name;
		this.isoCode = isoCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", isoCode=" + isoCode + "]";
	}

}

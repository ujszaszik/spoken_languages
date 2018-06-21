package solution;

public enum Urls {
	LANGUAGE("https://raw.githubusercontent.com/umpirsky/language-list/master/data/en/language.txt"),
	FIRST_NAME("https://raw.githubusercontent.com/dominictarr/random-name/master/first-names.txt"),
	LAST_NAME("https://raw.githubusercontent.com/arineng/arincli/master/lib/last-names.txt");
	
	private String url;
	
	private Urls(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

}

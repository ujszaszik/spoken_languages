package person.name;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import solution.Obtainer;
import solution.Urls;

public class NameObtainer implements Obtainer<String> {
	protected String url;

	public NameObtainer(Urls url) {
		this.url = url.getUrl();
	}

	@Override
	public List<String> obtain() {
		try {
			InputStream languages = new URL(url).openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(languages));
			return br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			System.err.println();
			return List.of();
		}
	}

}

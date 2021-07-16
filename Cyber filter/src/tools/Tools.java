package tools;

import java.net.URL;
import java.util.ArrayList;

public abstract class Tools {
	
	/**
	 * @param url
	 * @return The part after the first / for exemple : 
	 */
	public static ArrayList<String> urlDecomposition(URL url) {
		ArrayList<String> preAndSuffixUrl = new ArrayList<String>();
		String domainName = url.toString();
		String prefix = "";
		String suffix = "";
		int i = 0;
		if(domainName.charAt(0) == 'h'){			
			while(domainName.charAt(i) != '/') {
				prefix += domainName.charAt(i);
				i+=1;
			}
			prefix += "//";
			i+=3; // to get to the char after the second '/'
			preAndSuffixUrl.add(prefix);
		}
		
		while(domainName.charAt(i) != '/') {
			i+=1;
		}
		for(int j = i; j < domainName.length(); j++) {
			suffix += domainName.charAt(j);
		}
		preAndSuffixUrl.add(suffix);
		return preAndSuffixUrl;
	}

}

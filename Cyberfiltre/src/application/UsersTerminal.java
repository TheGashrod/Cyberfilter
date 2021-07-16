package application;

import java.net.URL;

public abstract class UsersTerminal {
	
	
	
	public String domaineNameFromURL(URL url) {
		return url.getHost();
	}
	
	public String demandResolutionForDn(String domainName) {
		String dn = domainName;
		return dn;
	}
	
	public static String byPass(URL url) {
		String newUrl = url.toString();
		newUrl += ".bypass";
		return newUrl;
	}

}

package tools;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

public abstract class Tools {
	
	/**
	 * @param url
	 * @return The URL decomposed to :
	 *  Prefix ( exp : https://)
	 *  Domain name
	 *  Suffix ( exp : /test/...) 
	 * @throws UnknownHostException 
	 */
	public static ArrayList<String> urlDecomposition(URL url) throws UnknownHostException {
		ArrayList<String> preAndSuffixUrl = new ArrayList<String>();
		String domainName = url.toString();
		String prefix = "";
		String suffix = "";
		int i = 0;
//		if(domainName.charAt(0) == 'h'){}  toutes les url commencent par http:..			
		while(domainName.charAt(i) != '/') {
			prefix += domainName.charAt(i);
			i+=1;
		}
		prefix += "//";
		i+=3; // to get to the char after the second '/'
		preAndSuffixUrl.add(prefix);
		
		preAndSuffixUrl.add(domainNameOfUrl(url));
			
		while(domainName.charAt(i) != '/') {
			i+=1;
		}
		for(int j = i; j < domainName.length(); j++) {
			suffix += domainName.charAt(j);
		}
		preAndSuffixUrl.add(suffix);
		
		preAndSuffixUrl.add(urlToIpAddr(url));
		return preAndSuffixUrl;
	}
	
	
	
	/**
	 * @param url
	 * @return @IP of a domain name
	 * @throws UnknownHostException
	 */
	public static String urlToIpAddr(URL url) throws UnknownHostException {
		InetAddress address = InetAddress.getByName(url.getHost());
	    String ip = address.getHostAddress();
	    return ip;
	}
	
	
	/**
	 * @param url
	 * @return Domain name of Url
	 */
	public static String domainNameOfUrl(URL url) {
		return url.getHost();
	}

}

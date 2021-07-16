package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

public abstract class Tools {

	
	
//#################################### FUNCTIONS LINKED TO THE URL : ###########################################################""""
	
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
	
	

	
//#################################### FUNCTIONS LINKED TO THE BYPASS : ###########################################################""""
	
	/**
	 * @return true if hhe user wants to bypass, false else
	 * @throws IOException
	 */
	public static boolean byPass() throws IOException {
		System.out.println("This is a dangerous link, tape: yes, if you still want to open it.");
		 // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
         // Reading data using readLine
        String input = reader.readLine();
        if(input.equals("yes")) {
        	return true;
        }
        else return false;
	}
	
	
	/**
	 * @param domainName
	 * @param byPassDelimiter : the string that we wanna add to the domainName
	 * @return The domainName with -bypass in it
	 */
	public static String addByPassStringToDomainName(String domainName, String byPassDelimiter) {
		int n = domainName.length();
		String newDomainName = "";
		int i = domainName.length()-1;
		while (domainName.charAt(i) != '.' && i>0) {
			i-=1;
		}
		i-=1;
		int b = n-(i+1);
		for (int j = 0; j<=i; j++) {
			newDomainName += domainName.charAt(j);
		}
		newDomainName += byPassDelimiter;
		while(b>0) {
			newDomainName += domainName.charAt(i+1);
			i+=1;
			b-=1;
		}
		return newDomainName;
	}
	
	
	public static boolean containsByPass(String domainName, String byPassDelimiter) {
		int m = byPassDelimiter.length();
		int i = domainName.length()-1;
		while (domainName.charAt(i) != '-' && i>0) {
			i-=1;
		}
		i-=1;
		String testByPassDelimiter = "";
		for (int j = 0; j<m; j++) {
			testByPassDelimiter += domainName.charAt(i+1);
			i+=1;
		}
		System.out.println(testByPassDelimiter);
		if (testByPassDelimiter.equals(byPassDelimiter)) {
			return true;
		}
		else return false;
	}
	

}

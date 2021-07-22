package application;

// ne pas oublier de régler le prob par rapport à containsbypassdelimiter

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import tools.DataBase;
import tools.Tools;

// Main scenario :

public class Main {
	
	public static void main(String[] args) throws IOException {
		// We make the hypothese that all urls demanded by the user are malicious
		
		// Data :
		URL url = new URL("http://phishing.badinternetdomain.com/");
		String byPassDelimiter = "-bypass";
		
		// The user first demand a dns resolution for an url exp : https://github.com/marketplace?category=&query=&type=apps&verification=
		
		// The SICAP first see if the domain name contains the bypassdelimiter
//		boolean containsBypassDelimiter = SICAP.containsByPassDelimiter(Tools.domainNameOfUrl(url), byPassDelimiter);
//		containsBypassDelimiter == false
		if (true) {
			User.dnsResolutionForUrl(url);
			boolean userBypassChoice = User.byPass();
			System.out.println("Bypass = " +userBypassChoice);
			
			if (userBypassChoice == true) {
				
				// Whitlsit the domain name for the user
				SICAP.whitelistTheDomainNameFortheMsIsdn(User.msIsdn, 55);
				
				// Make a dns resolution for the domain name with -bypassDelimiter
				String newDomainName = Tools.addByPassDelimiterStringToDomainName(Tools.domainNameOfUrl(url), byPassDelimiter);
				URL newUrl = new URL(DataBase.getDataByMsIsdnForDomainName(User.msIsdn, Tools.domainNameOfUrl(url)).get(0) + newDomainName +DataBase.getDataByMsIsdnForDomainName(User.msIsdn, Tools.domainNameOfUrl(url)).get(2));
				System.out.println("Dns resolution for : " + newUrl);
				User.dnsResolutionForUrl(newUrl);
				if (SICAP.containsByPassDelimiter(Tools.domainNameOfUrl(newUrl), byPassDelimiter)) {
					String originalDomainName = Tools.removeByPassDelimiter(Tools.domainNameOfUrl(newUrl), byPassDelimiter);
					String destinationIpAddr = DataBase.getDataByMsIsdnForDomainName(User.msIsdn, originalDomainName).get(0) + DataBase.getDataByMsIsdnForDomainName(User.msIsdn, originalDomainName).get(3) +DataBase.getDataByMsIsdnForDomainName(User.msIsdn, originalDomainName).get(2);
					System.out.println(destinationIpAddr);
				}
				
			}
			else System.out.println("Good choice ;) ");
		}
		
		
	}
}

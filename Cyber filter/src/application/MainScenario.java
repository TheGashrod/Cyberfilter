package application;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import tools.DataBase;
import tools.Tools;

// Main scenario :

public class MainScenario {
	
	public static void main(String[] args) throws IOException {
		// We make the hypothese that all urls demanded by the user are malicious
		
		// Data :
		URL url = new URL("http://phishing.badinternetdomain.com/");
		URL url2 = new URL("https://github.com/TheGashrod/Cyberfilter/tree/Tests");

		String byPassDelimiter = "-bypass";
		
		// The user first demand a dns resolution for an url exp : https://github.com/marketplace?category=&query=&type=apps&verification=
		
		// The SICAP first see if the domain name contains the bypassdelimiter
//		boolean containsBypassDelimiter = SICAP.containsByPassDelimiter(Tools.domainNameOfUrl(url), byPassDelimiter);
//		containsBypassDelimiter == false
		System.out.println("Data base by MsIsdn in the begining : "+ DataBase.getdBbyMsIsdn());
		if (true) {
			User.dnsResolutionForUrl(url2);
			System.out.println("Data Base by MsIsdn after the first dsn resolution : " + DataBase.getdBbyMsIsdn());
			
			System.out.println("########");
			
			boolean userBypassChoice = User.byPass();
			
			if (userBypassChoice == true) {
				System.out.println("You have chosen to bypass ");
				
				System.out.println("########");
				
				// Whitlsit the domain name for the user
				SICAP.whitelistTheDomainNameFortheMsIsdn(User.msIsdn, 55);
				
				// Make a dns resolution for the domain name with -bypassDelimiter
				String newDomainName = Tools.addByPassDelimiterStringToDomainName(Tools.domainNameOfUrl(url2), byPassDelimiter);
				URL newUrl = new URL(DataBase.getDataByMsIsdnForDomainName(User.msIsdn, Tools.domainNameOfUrl(url2)).get(0) + newDomainName +DataBase.getDataByMsIsdnForDomainName(User.msIsdn, Tools.domainNameOfUrl(url2)).get(2));
				User.dnsResolutionForUrl(newUrl);
				System.out.println("Dns resolution for : " + newUrl);
				
				System.out.println("########");

				if (SICAP.containsByPassDelimiter(Tools.domainNameOfUrl(newUrl), byPassDelimiter)) {
					String originalDomainName = Tools.removeByPassDelimiter(Tools.domainNameOfUrl(newUrl), byPassDelimiter);
					String destinationIpAddr = DataBase.getDataByMsIsdnForDomainName(User.msIsdn, originalDomainName).get(3);
					String equivalentUrl = DataBase.getDataByMsIsdnForDomainName(User.msIsdn, originalDomainName).get(0) + DataBase.getDataByMsIsdnForDomainName(User.msIsdn, originalDomainName).get(3) +DataBase.getDataByMsIsdnForDomainName(User.msIsdn, originalDomainName).get(2);
					System.out.println("The destination address ip for the MsIsdn and the domain name " + originalDomainName +"is : " + destinationIpAddr);
					System.out.println("Which is equivalent to the url : " + equivalentUrl);
				}
				
			}
			else System.out.println("Good choice ;) ");
		}
		
		
	}
}

package application;

import tools.MsIsdn;

public abstract class SICAP {
	
	public static void whitelistTheDomainNameFortheMsIsdn(MsIsdn msIsdn, int timeInMinutes) {
		System.out.println("[SICAP] : The domain name has been whitlisted for " + msIsdn + " for " + timeInMinutes + "minutes");
	}
	
	/**
	 * @param domainName
	 * @param byPassDelimiter
	 * @return true if the domain name contains the bypassDelimiter, false else
	 */
	public static boolean containsByPassDelimiter(String domainName, String byPassDelimiter) {
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
//		System.out.println(testByPassDelimiter);
		if (testByPassDelimiter.equals(byPassDelimiter)) {
			System.out.println("[SICAP] : a -byPassDelimiter has been detected");
			System.out.println("########");
			return true;
		}
		else return false;
	}

}

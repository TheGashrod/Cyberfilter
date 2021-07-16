/**
 * 
 */
package application;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

import tools.ListIpAddrByMsIsdn;
import tools.MsIsdn;
import tools.Tools;
import user.User; 

/**
 * @author dell
 *
 */
public class Main {
	
	
	public static void main(String[] args) throws UnknownHostException, MalformedURLException 
	{
		System.out.println("hello");
		
//		byte[] ipAddress = new byte[] {(byte)127, (byte)0, (byte)0, (byte)1 };
//	    InetAddress address = InetAddress.getByAddress(ipAddress);
//	    String hostnameCanonical = address.getCanonicalHostName();
//	    System.out.println(hostnameCanonical);
	    
		
		// problème : la conversion d'adresses url se fait à travers la conversion du nom de domaine en 
		// adresse ip et exemple l'adresse ip renvoyée pour youtube.com est celle de google.com car la vrai url est : 
	    URL url = new URL("https://github.com");
	    URL url2 = new URL("https://google.com");
	    URL url3 = new URL("https://facebook.com");
	    System.out.println(url.getHost());
	    System.out.println(url2.getHost());
	    System.out.println(url3.getHost());
	    
	    
	    // test byPass with .bypass in the end
	    String newUrl = UsersTerminal.byPass(url);
	    System.out.println(newUrl);
	    
	    // test convertion url to ipAdrr
	    String ip = Tools.urlToIpAddr(url);
	    String ip2 = Tools.urlToIpAddr(url2);
	   	String ip3 = Tools.urlToIpAddr(url3);
	    System.out.println(ip);
	    System.out.println(ip2);
	    System.out.println(ip3);
	    
	    
	    // test ListaddrByMsIsdn
	    MsIsdn msIsdn1 = new MsIsdn("0656113819");
	    MsIsdn msIsdn2 = new MsIsdn("0656223819");
	    MsIsdn msIsdn3 = new MsIsdn("0656333819");
	    
	    ListIpAddrByMsIsdn listMsIsdn1 = new ListIpAddrByMsIsdn(msIsdn1,ip3,url3,false);   
	    ListIpAddrByMsIsdn listMsIsdn2 = new ListIpAddrByMsIsdn(msIsdn2,ip2,url2,false);
	    
	    System.out.println(listMsIsdn1.getdBbyMsIsdn().get(msIsdn1).get(0));
	    System.out.println(listMsIsdn1.getdBbyMsIsdn().get(msIsdn1).get(0).get(1));
	    
	    System.out.println(listMsIsdn2.getdBbyMsIsdn().get(msIsdn2).get(0));
	    System.out.println(listMsIsdn2.getdBbyMsIsdn().get(msIsdn2).get(0).get(2));

	}
}

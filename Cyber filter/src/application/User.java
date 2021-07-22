/**
 * 
 */
package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

import tools.DataBase;
import tools.MsIsdn;
import tools.Tools;

public abstract class User {
	public static final MsIsdn msIsdn = new MsIsdn("0656743819");

	
	/**
	 * @return the msisdn
	 */
	public static MsIsdn getMsisdn() {
		return msIsdn;
	}
	
	public static void dnsResolutionForUrl(URL url) throws UnknownHostException {
		ArrayList<String> decomposedUrl = new ArrayList<String>();
		decomposedUrl = Tools.urlDecomposition(url);
		DataBase.addDataForMsIsdn(msIsdn, decomposedUrl);
	}
	
	
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

}

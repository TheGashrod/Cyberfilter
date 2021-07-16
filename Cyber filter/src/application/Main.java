/**
 * 
 */
package application;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

import tools.DataBase;
import tools.MsIsdn;
import tools.Tools;

/**
 * @author dell
 *
 */
public class Main {
	

	public static void main(String[] args) throws MalformedURLException, UnknownHostException	{
		URL url1 = new URL("http://www.Orange.com/test/stage/orange");
		URL url2 = new URL("http://www.badInternetconnection.com/test/Internship");
		
		// Test de la décomposition d'une url             ---> validé
		ArrayList<String> decomposedUrl1 = new ArrayList<String>();
		decomposedUrl1 = Tools.urlDecomposition(url1);
		System.out.println(decomposedUrl1);
		
		// test du stockage des données la base de donnée par MsIsdn           --->
		MsIsdn msIsdn1 = new MsIsdn("0612345678");
		DataBase.addDataForMsIsdn(msIsdn1, decomposedUrl1);
		
//		MsIsdn msIsdn2 = new MsIsdn("0687654321");
		ArrayList<String> decomposedUrl2 = new ArrayList<String>();
		decomposedUrl2 = Tools.urlDecomposition(url2);
		DataBase.addDataForMsIsdn(msIsdn1, decomposedUrl2);
		
		System.out.println(DataBase.getdBbyMsIsdn());
		
	}

}

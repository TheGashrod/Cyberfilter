/**
 * https://github.com/dnsjava/dnsjava  (for dns part)
 * https://www.pandasecurity.com/fr/mediacenter/technologie/proxy-et-comment-utiliser/   (how to use a proxy)
 */
package application;

import java.io.IOException;
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
	

	public static void main(String[] args) throws IOException	{
		URL url1 = new URL("http://www.Orange.com/test/stage/orange");
		URL url2 = new URL("http://www.badInternetconnection.com/test/Internship");
		
//		Test de la décomposition d'une url                                 ---> V
		ArrayList<String> decomposedUrl1 = new ArrayList<String>();
		decomposedUrl1 = Tools.urlDecomposition(url1);
		System.out.println(decomposedUrl1);
		
//      Test du stockage des données la base de donnée par MsIsdn          ---> V
		MsIsdn msIsdn1 = new MsIsdn("0612345678");
		DataBase.addDataForMsIsdn(msIsdn1, decomposedUrl1);
		
		//MsIsdn msIsdn2 = new MsIsdn("0687654321");
		ArrayList<String> decomposedUrl2 = new ArrayList<String>();
		decomposedUrl2 = Tools.urlDecomposition(url2);
		DataBase.addDataForMsIsdn(msIsdn1, decomposedUrl2);
		
		System.out.println(DataBase.getdBbyMsIsdn());
		
//		Test de la fonction byPass                                         ---> V
//		System.out.println(Tools.byPass());
		
//		Test de l'ajout de -bypass au nom de domaine                       ---> V
		String byPassDelimiter = "-slqfkdz###@@@@@"; 
		System.out.println(Tools.addByPassStringToDomainName(decomposedUrl1.get(1), byPassDelimiter));
		System.out.println(Tools.addByPassStringToDomainName(decomposedUrl2.get(1), byPassDelimiter));
		
		
//      Test le fait de reperer -bypass dans un nom de domain
		String newDomainName = Tools.addByPassStringToDomainName(decomposedUrl1.get(1), byPassDelimiter);
		System.out.println(Tools.containsByPass(newDomainName, byPassDelimiter));
	}

}

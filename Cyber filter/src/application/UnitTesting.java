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
public class UnitTesting {
	

	public static void main(String[] args) throws IOException	{
		URL url1 = new URL("http://www.Orange.com/test/stage/orange");
		URL url2 = new URL("http://www.badInternetconnection.com/test/Internship");
		
//		Test de la décomposition d'une url                                 ---> V
		ArrayList<String> decomposedUrl1 = new ArrayList<String>();
		decomposedUrl1 = Tools.urlDecomposition(url1);
		System.out.println(decomposedUrl1);
		System.out.println("test 1 validé");

		
//      Test du stockage des données la base de donnée par MsIsdn          ---> V
		MsIsdn msIsdn1 = new MsIsdn("0612345678");
		DataBase.addDataForMsIsdn(msIsdn1, decomposedUrl1);
		System.out.println("test 2 validé");

		
		//MsIsdn msIsdn2 = new MsIsdn("0687654321");
		ArrayList<String> decomposedUrl2 = new ArrayList<String>();
		decomposedUrl2 = Tools.urlDecomposition(url2);
		DataBase.addDataForMsIsdn(msIsdn1, decomposedUrl2);
		
		System.out.println(DataBase.getdBbyMsIsdn());
		
//		Test de la fonction byPass                                         ---> V
		System.out.println(Tools.byPass());
		
//		Test de l'ajout de -bypass au nom de domaine                       ---> V
		String byPassDelimiter = "-j_sq@@@//dsLFKSGJ"; 
		System.out.println(Tools.addByPassDelimiterStringToDomainName(decomposedUrl1.get(1), byPassDelimiter));
		System.out.println(Tools.addByPassDelimiterStringToDomainName(decomposedUrl2.get(1), byPassDelimiter));
		System.out.println("test 3o validé");
		
		
//      Test le fait de reperer -bypassDelimiter dans un nom de domain     ---> V
		String newDomainName = Tools.addByPassDelimiterStringToDomainName(decomposedUrl2.get(1), byPassDelimiter);
		System.out.println(Tools.containsByPassDelimiter(newDomainName, byPassDelimiter));
		
//      Test retirer -bypassDelimiter du nom de domaine 					---> V
		System.out.println(Tools.removeByPassDelimiter(newDomainName, byPassDelimiter));
		
		
//      Test retourner la réelle adresse ip du nom de domaine contenant -bypassDelimiter en cherchant dans la base de données par msIsdn  ---> V
		String originalDomainName = Tools.removeByPassDelimiter(newDomainName, byPassDelimiter);
		System.out.println(Tools.FinalIpAddrOfTheDomainName(msIsdn1, originalDomainName));
	}

}

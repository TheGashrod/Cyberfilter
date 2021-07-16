/**
 * 
 */
package application;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import tools.Tools;

/**
 * @author dell
 *
 */
public class Main {
	

	public static void main(String[] args) throws MalformedURLException	{
		URL url = new URL("http://github.com/test/commecr/orange");
		String prefix;
		ArrayList<String> preAndSuffixUrl = new ArrayList<String>();
		preAndSuffixUrl = Tools.urlDecomposition(url);
		System.out.println(preAndSuffixUrl.get(0));
		System.out.println(preAndSuffixUrl.get(1));
		
	}

}

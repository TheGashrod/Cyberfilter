/**
 * 
 */
package tools;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author dell
 *
 */
public class ListIpAddrByMsIsdn {
	private MsIsdn msIsdn;
	private ArrayList<ArrayList<Object>> listByMsIsdn = new ArrayList<ArrayList<Object>>();
	
//	private String ipadrr;
//	private URL url;
//	private boolean blackListed = true;
//	private ArrayList<Object> listByMsIsdn = new ArrayList<>();
	
	


/*
 * Cheminnement :
 * Instancier la ListIpAddrByMsIsdn  avec le constructeur en donnant que le msIsdn, 
 * puis ajouter les blcklisted adresses ip dans la listByMsIsdn qui est la base données pour un msIsdn ( addListByMsIsdn),
 * puis finalemnt tout ajouter dans la grande base de données de tous les msIsdn ( addListIpAddrByMsIsdnToDB).
 * 	
 */
	
	
// Constructor : on donne que le msIsdn
	public ListIpAddrByMsIsdn(MsIsdn msIsdn) {
		this.msIsdn = msIsdn;
	}
	
	
	
	
	public void addListByMsIsdn( String ipadrr, URL url, boolean blackListed) {
		ArrayList<Object> list =new ArrayList<Object>();
		list.add(ipadrr);
		list.add(url);
		list.add(blackListed);
		this.listByMsIsdn.add(list);
	}
	
	public void addListIpAddrByMsIsdnToDB() {
		DataBas
		
	}
	
	
//	public ArrayList<Object> listIpAddrByMsIsdn(){
//		ArrayList<Object> listByMsIsdn = new ArrayList<>();
//		listByMsIsdn.add(ipadrr);
//		listByMsIsdn.add(url);
//		listByMsIsdn.add(blackListed);
//		return listByMsIsdn;
//	}
	
//	public void addToTheWhiteListedDB(ArrayList<Object> listIpAddrByMsIsdn) {
//		this.
//		
//	}
}

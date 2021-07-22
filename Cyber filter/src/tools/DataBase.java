package tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public abstract class DataBase {
	
	private static  HashMap<MsIsdn, ArrayList<ArrayList<String>>> dBbyMsIsdn = new HashMap<MsIsdn, ArrayList<ArrayList<String>>>();
	
	
	
	/**
	 * @return the dBbyMsIsdn
	 */
	public static HashMap<MsIsdn, ArrayList<ArrayList<String>>> getdBbyMsIsdn() {
		return dBbyMsIsdn;
	}



	/**
	 * @param msIsdn
	 * @param decomposedUrl
	 * In order to add a "decomposed url" to a msIsdn, this function first search in the data base if the msIsdn already exists,
	 * if not, it puts it as a new msIsdn and a new data base that contains the "decomposed url" 
	 * 
	 **/
	public static void addDataForMsIsdn(MsIsdn msIsdn, ArrayList<String> decomposedUrl) {
		boolean msIsdnIsAlreadyInTheList = false;
		for(Map.Entry<MsIsdn, ArrayList<ArrayList<String>>> mapentry : dBbyMsIsdn.entrySet()) {
        	if(mapentry.getKey().equals(msIsdn)) {
        		mapentry.getValue().add(decomposedUrl);
        		msIsdnIsAlreadyInTheList = true;
        	}
        }
		if (msIsdnIsAlreadyInTheList == false) {
			ArrayList<ArrayList<String>> newDataForMsIsdn = new ArrayList<ArrayList<String>>();
			newDataForMsIsdn.add(decomposedUrl);
			dBbyMsIsdn.put(msIsdn, newDataForMsIsdn);
		}
	}
	
	public static ArrayList<String> getDataByMsIsdnForDomainName(MsIsdn msIsdn, String domainName){
		ArrayList<String> data = new ArrayList<String>();
		for(Map.Entry<MsIsdn, ArrayList<ArrayList<String>>> mapentry : dBbyMsIsdn.entrySet()) {
        	if(mapentry.getKey().equals(msIsdn)) {
        		int m = mapentry.getValue().size();
        		for(int i = 0; i<m; i++) {
        			if (mapentry.getValue().get(i).get(1).equals(domainName)){
        				
        				data = mapentry.getValue().get(i);
        				
        			}
        		}
        	}
//        	else System.out.println("There is no data enregistred for this msIsdn and this domain name");
        }
		return data;
	}

}

package tools;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class DataBase {
	private HashMap<MsIsdn, ArrayList<ArrayList<Object>>> dBbyMsIsdn = new HashMap<MsIsdn, ArrayList<ArrayList<Object>>>();
	
	/**
	 * @return the dBbyMsIsdn
	 */
	public HashMap<MsIsdn, ArrayList<ArrayList<Object>>> getdBbyMsIsdn() {
		return dBbyMsIsdn;
	}
	
	

}

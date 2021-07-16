/**
 * 
 */
package application;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;

import tools.ListIpAddrByMsIsdn;
import tools.MsIsdn;

/**
 * @author dell
 *
 */
public class SICAP {
	
	private HashMap<MsIsdn, ArrayList<Object>> capitalCities = new HashMap<MsIsdn, ArrayList<Object>>();
	
	public Boolean CheckBlackList(InetAddress addr) {
		return true;
	}

//	public InetAddress returnDestinationIp() {
//	}
	
	public boolean WhiteListIpForMsIsdn(ListIpAddrByMsIsdn listMsIsdn, MsIsdn msIsdn) {
		listMsIsdn.getdBbyMsIsdn()
	}
}

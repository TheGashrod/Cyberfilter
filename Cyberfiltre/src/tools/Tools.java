package tools;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public abstract class Tools {

	
	public static String urlToIpAddr(URL url) throws UnknownHostException {
		InetAddress address = InetAddress.getByName(url.getHost());
	    String ip = address.getHostAddress();
	    return ip;
	}
}

package user;

import tools.MsIsdn;

public abstract class User {
	public static final MsIsdn msIsdn = new MsIsdn("0656743819");

	/**
	 * @return the msisdn
	 */
	public static MsIsdn getMsisdn() {
		return msIsdn;
	}

}

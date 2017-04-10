package net.pms.util.jna;

import com.sun.jna.NativeLong;


public class IOConnectT extends MachPortT {

	/**
	 * Current serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public IOConnectT() {
	}

	public IOConnectT(int value) {
		super(value);
	}

	public IOConnectT(long value) {
		super(value);
	}

	public IOConnectT(NativeLong value) {
		super(value);
	}
}

package net.pms.util.jna;

import com.sun.jna.NativeLong;


public class IOServiceT extends IORegistryEntryT {

	/**
	 * Current serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public IOServiceT() {
	}

	public IOServiceT(int value) {
		super(value);
	}

	public IOServiceT(long value) {
		super(value);
	}

	public IOServiceT(NativeLong value) {
		super(value);
	}
}

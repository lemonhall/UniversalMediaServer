package net.pms.util.jna;

import com.sun.jna.NativeLong;


public class IORegistryEntryT extends IOObjectT {

	/**
	 * Current serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public IORegistryEntryT() {
	}

	public IORegistryEntryT(int value) {
		super(value);
	}

	public IORegistryEntryT(long value) {
		super(value);
	}

	public IORegistryEntryT(NativeLong value) {
		super(value);
	}
}

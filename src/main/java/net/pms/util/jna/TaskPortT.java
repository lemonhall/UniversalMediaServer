package net.pms.util.jna;

import com.sun.jna.NativeLong;


public class TaskPortT extends MachPortT {

	/**
	 * Current serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	public TaskPortT() {
	}

	public TaskPortT(int value) {
		super(value);
	}

	public TaskPortT(long value) {
		super(value);
	}

	public TaskPortT(NativeLong value) {
		super(value);
	}
}

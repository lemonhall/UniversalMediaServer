package net.pms.util.jna;

import com.sun.jna.NativeLong;

/**
 * Represents the {@code mach_port_t} type.
 */
public class MachPortT extends NativeLong {

	private static final long serialVersionUID = 1L;

	/**
	 * The {@link MachPortT} {@code null} value.
	 */
	public static final int MACH_PORT_NULL = 0;

	/**
	 * Creates a new instance with value {@code 0}.
	 */
	public MachPortT() {
		super(0, true);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public MachPortT(int value) {
		super(value, true);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public MachPortT(long value) {
		super(value, true);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public MachPortT(NativeLong value) {
		super(value.longValue(), true);
	}
}

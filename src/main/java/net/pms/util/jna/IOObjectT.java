package net.pms.util.jna;

import com.sun.jna.NativeLong;

/**
 * Represents the {@code io_object_t} type.
 */
public class IOObjectT extends MachPortT {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance with value {@code 0}.
	 */
	public IOObjectT() {
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IOObjectT(int value) {
		super(value);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IOObjectT(long value) {
		super(value);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IOObjectT(NativeLong value) {
		super(value.longValue());
	}

	/**
	 * Creates a new {@link IOObjectT} from any {@link MachPortT} or subclass
	 * instance. Since these object aren't created by Java, they aren't created
	 * with their proper type and as a result can't be cast from
	 * {@link MachPortT} to {@link IOObjectT}. Use this method as a replacement
	 * for casting.
	 *
	 * @param machPort the {@link MachPortT} or subclass to "cast" from.
	 * @return The new {@link IOObjectT} instance.
	 */
	public static IOObjectT toIOObjectT(MachPortT machPort) {
		return machPort == null ? null : new IOObjectT(machPort.longValue());
	}
}

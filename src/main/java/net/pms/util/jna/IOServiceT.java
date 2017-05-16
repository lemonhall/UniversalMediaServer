package net.pms.util.jna;

import com.sun.jna.NativeLong;

/**
 * Represents the {@code io_service_t} type.
 */
public class IOServiceT extends IORegistryEntryT {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance with value {@code 0}.
	 */
	public IOServiceT() {
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IOServiceT(int value) {
		super(value);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IOServiceT(long value) {
		super(value);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IOServiceT(NativeLong value) {
		super(value);
	}

	/**
	 * Creates a new {@link IOServiceT} from any {@link MachPortT} or subclass
	 * instance. Since these object aren't created by Java, they aren't created
	 * with their proper type and as a result can't be cast from
	 * {@link MachPortT} to {@link IOServiceT}. Use this method as a replacement
	 * for casting.
	 *
	 * @param machPort the {@link MachPortT} or subclass to "cast" from.
	 * @return The new {@link IOServiceT} instance.
	 */
	public static IOServiceT toIOServiceT(MachPortT machPort) {
		return machPort == null ? null : new IOServiceT(machPort.longValue());
	}
}

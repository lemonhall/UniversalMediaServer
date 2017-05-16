package net.pms.util.jna;

import com.sun.jna.NativeLong;

/**
 * Represents the {@code io_registry_entry_t} type.
 */
public class IORegistryEntryT extends IOObjectT {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance with value {@code 0}.
	 */
	public IORegistryEntryT() {
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IORegistryEntryT(int value) {
		super(value);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IORegistryEntryT(long value) {
		super(value);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IORegistryEntryT(NativeLong value) {
		super(value);
	}

	/**
	 * Creates a new {@link IORegistryEntryT} from any {@link MachPortT} or
	 * subclass instance. Since these object aren't created by Java, they aren't
	 * created with their proper type and as a result can't be cast from
	 * {@link MachPortT} to {@link IORegistryEntryT}. Use this method as a
	 * replacement for casting.
	 *
	 * @param machPort the {@link MachPortT} or subclass to "cast" from.
	 * @return The new {@link IORegistryEntryT} instance.
	 */
	public static IORegistryEntryT toIORegistryT(MachPortT machPort) {
		return machPort == null ? null : new IORegistryEntryT(machPort.longValue());
	}
}

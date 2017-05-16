package net.pms.util.jna;

import com.sun.jna.NativeLong;

/**
 * Represents the {@code io_iterator_t} type.
 */
public class IOIteratorT extends IOObjectT {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance with value {@code 0}.
	 */
	public IOIteratorT() {
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IOIteratorT(int value) {
		super(value);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IOIteratorT(long value) {
		super(value);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IOIteratorT(NativeLong value) {
		super(value.longValue());
	}

	/**
	 * Creates a new {@link IOIteratorT} from any {@link MachPortT} or subclass
	 * instance. Since these object aren't created by Java, they aren't created
	 * with their proper type and as a result can't be cast from
	 * {@link MachPortT} to {@link IOIteratorT}. Use this method as a
	 * replacement for casting.
	 *
	 * @param machPort the {@link MachPortT} or subclass to "cast" from.
	 * @return The new {@link IOIteratorT} instance.
	 */
	public static IOIteratorT toIOIteratorT(MachPortT machPort) {
		return machPort == null ? null : new IOIteratorT(machPort.longValue());
	}
}

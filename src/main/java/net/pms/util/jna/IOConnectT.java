package net.pms.util.jna;

import com.sun.jna.NativeLong;


/**
 * Represents the {@code io_connect_t} type.
 */
public class IOConnectT extends MachPortT {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance with value {@code 0}.
	 */
	public IOConnectT() {
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IOConnectT(int value) {
		super(value);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IOConnectT(long value) {
		super(value);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public IOConnectT(NativeLong value) {
		super(value);
	}

	/**
	 * Creates a new {@link IOConnectT} from any {@link MachPortT} or subclass
	 * instance. Since these object aren't created by Java, they aren't created
	 * with their proper type and as a result can't be cast from
	 * {@link MachPortT} to {@link IOConnectT}. Use this method as a replacement
	 * for casting.
	 *
	 * @param machPort the {@link MachPortT} or subclass to "cast" from.
	 * @return The new {@link IOConnectT} instance.
	 */
	public static IOConnectT toIOConnectT(MachPortT machPort) {
		return machPort == null ? null : new IOConnectT(machPort.longValue());
	}
}

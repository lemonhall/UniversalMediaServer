package net.pms.util.jna;

import com.sun.jna.NativeLong;

/**
 * Represents the {@code mach_port_t} type.
 */
public class MachPortT extends NativeLong {

	/**
	 * Current serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The {@link MachPortT} {@code null} value.
	 */
	public static final int MACH_PORT_NULL = 0;

	/**
	 * Create a {@link MachPortT} from a native pointer. <b>Don't use this
	 * unless you know what you're doing</b>.
	 * <p>
	 * Generally {@link MachPortT} shouldn't be instantiated from Java. Use it
	 * to hold {@code mach_port_t} instances returned from function calls.
	 */
	/*public MachPortT(long peer) {
		super(peer);
	}*/

	public MachPortT() {
		super(0, true);
	}

	public MachPortT(int value) {
		super(value, true);
	}

	public MachPortT(long value) {
		super(value, true);
	}

	public MachPortT(NativeLong value) {
		super(value.longValue(), true);
	}

	/*@Override
	public MachPortT fromNative(Object nativeValue, FromNativeContext context) {
        // Always pass along null pointer values
        if (nativeValue == null) {
            return null;
        }
        //TODO: Possible memory leak
        setPointer((Pointer) nativeValue);
        return this;
	}
	*/

}

package net.pms.util.jna;

import com.sun.jna.NativeLong;

/**
 * Represents the {@code io_object_t} type.
 */
public class IOObjectT extends MachPortT {

	/**
	 * Current serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create a {@link IOObjectT} from a native pointer. <b>Don't use this
	 * unless you know what you're doing</b>.
	 * <p>
	 * Generally {@link IOObjectT} shouldn't be instantiated from Java. Use it
	 * to hold {@code io_object_t} instances returned from function calls.
	 */
	/*public IOObjectT(long peer) {
		super(peer);
	}*/

	public IOObjectT() {		
	}
	
	public IOObjectT(int value) {
		super(value);		
	}
	
	public IOObjectT(long value) {
		super(value);
	}
	
	public IOObjectT(NativeLong value) {
		super(value.longValue());
	}
	
}

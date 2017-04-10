package net.pms.util.jna;

import com.sun.jna.NativeLong;

/**
 * Represents the {@code io_iterator_t} type.
 */
public class IOIteratorT extends IOObjectT {

	/**
	 * Current serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create a {@link IOIteratorT} from a native pointer. <b>Don't use this
	 * unless you know what you're doing</b>.
	 * <p>
	 * Generally {@link IOIteratorT} shouldn't be instantiated from Java. Use it
	 * to hold {@code io_iterator_t} instances returned from function calls.
	 */
	/*public IOIteratorT(long peer) {
		super(peer);
	}*/

	public IOIteratorT() {		
	}
	
	public IOIteratorT(int value) {
		super(value);		
	}
	
	public IOIteratorT(long value) {
		super(value);
	}
	
	public IOIteratorT(NativeLong value) {
		super(value.longValue());
	}
	
}

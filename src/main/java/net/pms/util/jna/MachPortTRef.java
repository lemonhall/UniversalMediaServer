package net.pms.util.jna;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * Represents the {@code mach_port_t} type.
 */
public class MachPortTRef extends PointerType {

	/**
	 * Create a {@link MachPortTRef} from a native pointer. <b>Don't use this
	 * unless you know what you're doing</b>.
	 * <p>
	 * Generally {@link MachPortTRef} shouldn't be instantiated from Java. Use it
	 * to hold {@code mach_port_t} instances returned from function calls.
	 */
	/*public MachPortT(long peer) {
		super(peer);
	}*/

	public MachPortTRef() {
	}

	public MachPortTRef(boolean allocate) {
		super(allocate ? new Memory(Native.LONG_SIZE) : Pointer.NULL);
	}

	public MachPortTRef(MachPortT port) {
		this(true);
		if (port == null) {
			throw new NullPointerException("port cannot be null");
		}
		getPointer().setNativeLong(0, port);
	}

	public MachPortT getValue() {
		if (getPointer() == null) {
			return null;
		}
		return new MachPortT(getPointer().getNativeLong(0));
	}
}

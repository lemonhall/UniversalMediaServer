package net.pms.util.jna;

import com.sun.jna.NativeLong;


/**
 * Represents the {@code task_port_t} type.
 */
public class TaskPortT extends MachPortT {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance with value {@code 0}.
	 */
	public TaskPortT() {
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public TaskPortT(int value) {
		super(value);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public TaskPortT(long value) {
		super(value);
	}

	/**
	 * Creates a new instance with value {@code value}.
	 *
	 * @param value the value of the new instance.
	 */
	public TaskPortT(NativeLong value) {
		super(value);
	}

	/**
	 * Creates a new {@link TaskPortT} from any {@link MachPortT} or subclass
	 * instance. Since these object aren't created by Java, they aren't created
	 * with their proper type and as a result can't be cast from
	 * {@link MachPortT} to {@link TaskPortT}. Use this method as a replacement
	 * for casting.
	 *
	 * @param machPort the {@link MachPortT} or subclass to "cast" from.
	 * @return The new {@link TaskPortT} instance.
	 */
	public static TaskPortT toTaskPortT(MachPortT machPort) {
		return machPort == null ? null : new TaskPortT(machPort.longValue());
	}
}

package net.pms.io.iokit;

/**
 * Maps OS X {@code kern_return_t} integer values to their defined names as defined
 * in {@code error.h}.
 * Use {@link MachError#getValue} to convert an {@link MachError} to its integer
 * value. Use {@link MachError#typeOf} to convert an integer value to an
 * {@link MachError}.
 *
 * @author Nadahar
 */
public class MachError implements KernReturnT {

	/** Success / No error / Routine {@code null} */
	static final MachError SUCCESS = new MachError(0);

	static final MachError none = SUCCESS;

	static final MachError ROUTINE_NIL = SUCCESS;

	final int code;

	protected MachError(int code) {
		this.code = code;
	}

	@Override
	public int getValue() {
		return code;
	}

	/**
	 * Represents the macro {@code err_get_system(err)} in {@code error.h}.
	 *
	 * @param kernReturn the {@link KernReturnT} instance.
	 * @return The extracted {@code system} part of a {@link KernReturnT}
	 *         return code.
	 */
	public static int getSystemCode(KernReturnT kernReturn) {
		return getSystemCode(kernReturn.getValue());
	}

	/**
	 * Represents the macro {@code err_get_system(err)} in {@code error.h}.
	 *
	 * @param kernReturn the {@link KernReturnT} return code.
	 * @return The extracted {@code system} part of a {@link KernReturnT}
	 *         return code.
	 */
	public static int getSystemCode(int kernReturn) {
		return (kernReturn >> 26) & 0x3f;
	}

	/**
	 * Translates the {@code system} part of a {@link KernReturnT} return code
	 * into a corresponding {@link Enum} if known. If the code isn't recognized,
	 * {@code null} is returned. Use {@link #getSystemCode} to get the integer
	 * code.
	 *
	 * @param kernReturn the {@link KernReturnT} instance.
	 * @return An {@link Enum} representing the {@code system} part of a
	 *         {@link KernReturnT} return code or {@code null} if the code isn't
	 *         recognized.
	 */
	public static System getSystem(KernReturnT kernReturn) {
		return System.typeOf(getSystemCode(kernReturn.getValue()));
	}

	/**
	 * Represents the macro {@code err_get_sub(err)} in {@code error.h}.
	 *
	 * @param kernReturn the {@link KernReturnT} instance.
	 * @return The extracted {@code subsystem} part of a {@link KernReturnT}
	 *         return code.
	 */
	public static int getSubsystemCode(KernReturnT kernReturn) {
		return getSubsystemCode(kernReturn.getValue());
	}

	/**
	 * Represents the macro {@code err_get_sub(err)} in {@code error.h}.
	 *
	 * @param kernReturn the {@link KernReturnT} return code.
	 * @return The extracted {@code subsystem} part of a {@link KernReturnT}
	 *         return code.
	 */
	public static int getSubsystemCode(int kernReturn) {
		return (kernReturn >> 14) & 0xfff;
	}

	/**
	 * Translates the {@code subsystem} part of a {@link KernReturnT} return
	 * code into a corresponding {@link Enum} if known. If the code isn't
	 * recognized, {@code null} is returned. Use {@link #getSubsystemCode} to
	 * get the integer code.
	 *
	 * @param kernReturn the {@link KernReturnT} instance.
	 * @return An {@link Enum} representing the {@code subsystem} part of a
	 *         {@link KernReturnT} return code or {@code null} if the code isn't
	 *         recognized.
	 */
	public static Subsystem getSubsystem(KernReturnT kernReturn) {
		return Subsystem.typeOf(getSubsystemCode(kernReturn.getValue()));
	}

	/**
	 * Represents the macro {@code err_get_code(err)} in {@code error.h}.
	 *
	 * @param kernReturn the {@link KernReturnT} instance.
	 * @return The extracted {@code error code} part of a {@link KernReturnT}
	 *         return code.
	 */
	public static int getErrorCode(KernReturnT kernReturn) {
		return getErrorCode(kernReturn.getValue());
	}

	/**
	 * Represents the macro {@code err_get_code(err)} in {@code error.h}.
	 *
	 * @param kernReturn the {@link KernReturnT} return code.
	 * @return The extracted {@code error code} part of a {@link KernReturnT}
	 *         return code.
	 */
	public static int getErrorCode(int kernReturn) {
		return kernReturn & 0x3fff;
	}

	/**
	 * Maps the OS X {@code system} part of a {@link KernReturnT} error to their
	 * integer values.
	 * <p>
	 * Use {@link System#getValue} to convert an {@link System} to its integer
	 * value. Use {@link System#typeOf} to convert an integer value to an
	 * {@link System}.
	 *
	 * @author Nadahar
	 */
	public enum System {

		/** Kernel */
		err_kern(0x0),

		/** User space library */
		err_us(0x1),

		/** User space servers */
		err_server(0x2),

		/** Old ipc errors */
		err_ipc(0x3),

		/** Mach-ipc errors */
		err_mach_ipc(0x4),

		/** Distributed ipc */
		err_dipc(0x7),

		/** User defined errors */
		err_local(0x3e),

		/** Mach-ipc errors (compatibility) */
		err_ipc_compat(0x3f),

		err_max_system(0x3f);

		private final int value;

		private System(int value) {
			this.value = value;
		}

		/**
		 * @return The system error code value of this {@link System}.
		 */
		public int getValue() {
			return value;
		}

		/**
		 * @param the {@code System} integer value.
		 * @return The corresponding {@link System}.
		 */
		public static System typeOf(int systemCode) {
			for (System entry : System.values()) {
				if (entry.getValue() == systemCode) {
					return entry;
				}
			}
			return null;
		}
	}

	/**
	 * Maps the OS X {@code Subsystem} part of a {@link KernReturnT} error to
	 * their integer values.
	 * <p>
	 * Use {@link Subsystem#getValue} to convert an {@link Subsystem} to its
	 * integer value. Use {@link Subsystem#typeOf} to convert an integer value
	 * to an {@link Subsystem}.
	 *
	 * @author Nadahar
	 */
	public enum Subsystem {

		/** Unix error */
		unix_err(0x3);

		private final int value;

		private Subsystem(int value) {
			this.value = value;
		}

		/**
		 * @return The subsystem error code value of this {@link Subsystem}.
		 */
		public int getValue() {
			return value;
		}

		/**
		 * @param the {@code Subsystem} integer value.
		 * @return The corresponding {@link Subsystem}.
		 */
		public static Subsystem typeOf(int subSystemCode) {
			for (Subsystem entry : Subsystem.values()) {
				if (entry.getValue() == subSystemCode) {
					return entry;
				}
			}
			return null;
		}
	}

}

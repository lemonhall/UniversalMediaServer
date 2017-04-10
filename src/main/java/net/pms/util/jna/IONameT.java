package net.pms.util.jna;

import java.nio.charset.Charset;

/**
 * An implementation of {@code io_name_t} as specified in
 * {@code devices/devices.defs}.
 *
 * @author Nadahar
 */
public class IONameT extends FixedCharArrayByReference {

	/**
	 * The size of the native array of 8-bit chars referenced by {@link IONameT}
	 * .
	 */
	public static final long SIZE = 128;

	/**
	 * Creates an unallocated {@link IONameT}.
	 */
	public IONameT() {
		super(SIZE);
	}

	/**
	 * Creates a new instance.
	 *
	 * @param allocate if {@code true} {@link com.sun.jna.Memory} is allocated
	 *            for the referenced array.
	 */
	public IONameT(boolean allocate) {
		super(SIZE);
		if (allocate) {
			setByteArray(new byte[(int) SIZE]);
		}
	}

	/**
	 * Creates a new {@link IONameT} and sets its content to {@code content}.
	 * <p>
	 * <b>Relying on the default charset can often lead to bugs. Use
	 * {@link #IONameT(String, Charset)} instead.</b>
	 *
	 * @param content the {@link String} to store in the referenced 8-bit char
	 *            array.
	 */
	public IONameT(String content) {
		super(SIZE);
		setString(content);
	}

	/**
	 * Creates a new {@link IONameT} and sets its content to {@code content}.
	 *
	 * @param content the {@link String} to store in the referenced 8-bit char
	 *            array.
	 * @param charset the {@link Charset} to use when encoding {@code content}.
	 */
	public IONameT(String content, Charset charset) {
		super(SIZE);
		setString(content, charset);
	}
}

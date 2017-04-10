package net.pms.io.iokit;

/**
 * Common interface for all {@code kern_return_t} values, which maps return
 * codes to {@link KernReturnT} instances.
 *
 * @author Nadahar
 */
public interface KernReturnT {

	/**
	 * @return The integer value for this instance.
	 */
	int getValue();
}

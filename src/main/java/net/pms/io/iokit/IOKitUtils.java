package net.pms.io.iokit;

import java.io.IOException;
import net.pms.util.jna.CoreFoundation;
import net.pms.util.jna.CoreFoundation.CFMutableDictionaryRefByReferance;
import net.pms.util.jna.CoreFoundation.CFStringRef;
import net.pms.util.jna.CoreFoundation.CFTypeRef;
import net.pms.util.jna.CoreFoundation.CFTypeRefByReferance;
import net.pms.util.jna.IOIteratorTRef;
import net.pms.util.jna.IORegistryEntryT;

public class IOKitUtils {

	private IOKitUtils() {
	}

	public static int getSystemIdleTiem() throws IOKitException {
		CoreFoundation coreFoundation = CoreFoundation.INSTANCE;
		IOIteratorTRef iterator = new IOIteratorTRef(true);
		IOKit ioKit = IOKit.INSTANCE;
		KernReturnT ioReturn = ioKit.IOServiceGetMatchingServices(null, ioKit.IOServiceMatching("IOHIDSystem"), iterator);
		try {
			if (ioReturn == DefaultKernReturnT.KERN_SUCCESS) {
				IORegistryEntryT entry = IORegistryEntryT.toIORegistryT(ioKit.IOIteratorNext(iterator.getValue()));
				if (entry != null) {
					try {
						CFMutableDictionaryRefByReferance dictionaryRef = new CFMutableDictionaryRefByReferance();
						ioReturn = ioKit.IORegistryEntryCreateCFProperties(entry, dictionaryRef, CoreFoundation.ALLOCATOR, 0);
						if (ioReturn == DefaultKernReturnT.KERN_SUCCESS) {
							try {
								CFTypeRef cfNumber = coreFoundation.CFDictionaryGetValue(dictionaryRef.getCFMutableDictionaryRef(), CFStringRef.toCFStringRef("HIDIdleTime"));
								System.out.println("jess");

							} finally {
								//coreFoundation.CFRelease(dictionary);
							}
						} else {
							//TODO: Handle
						}
					} finally {
						ioKit.IOObjectRelease(entry);
					}
				} else {
					throw new IOKitException("IOHIDSystem not found");
				}
			} else {
				throw new IOKitException("IOServiceGetMatchingServices failed with error code " + Integer.toHexString(ioReturn.getValue()) + ": " + ioReturn);
			}
		} finally {
			if (iterator != null) {
				ioKit.IOObjectRelease(iterator.getValue());
			}
		}

		return 0;
	}

	public static class IOKitException extends IOException {

		private static final long serialVersionUID = 1L;

	    /**
	     * Constructs an {@code IOKitException} with {@code null}
	     * as its error detail message.
	     */
	    public IOKitException() {
	        super();
	    }

	    /**
	     * Constructs an {@code IOKitException} with the specified detail message. //TODO: (Nad) Fix Javadocs
	     *
	     * @param message
	     *        The detail message (which is saved for later retrieval
	     *        by the {@link #getMessage()} method)
	     */
	    public IOKitException(String message) {
	        super(message);
	    }

	    /**
	     * Constructs an {@code IOException} with the specified detail message
	     * and cause.
	     *
	     * <p> Note that the detail message associated with {@code cause} is
	     * <i>not</i> automatically incorporated into this exception's detail
	     * message.
	     *
	     * @param message
	     *        The detail message (which is saved for later retrieval
	     *        by the {@link #getMessage()} method)
	     *
	     * @param cause
	     *        The cause (which is saved for later retrieval by the
	     *        {@link #getCause()} method).  (A null value is permitted,
	     *        and indicates that the cause is nonexistent or unknown.)
	     *
	     * @since 1.6
	     */
	    public IOKitException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    /**
	     * Constructs an {@code IOException} with the specified cause and a
	     * detail message of {@code (cause==null ? null : cause.toString())}
	     * (which typically contains the class and detail message of {@code cause}).
	     * This constructor is useful for IO exceptions that are little more
	     * than wrappers for other throwables.
	     *
	     * @param cause
	     *        The cause (which is saved for later retrieval by the
	     *        {@link #getCause()} method).  (A null value is permitted,
	     *        and indicates that the cause is nonexistent or unknown.)
	     *
	     * @since 1.6
	     */
	    public IOKitException(Throwable cause) {
	        super(cause);
	    }


	}
}

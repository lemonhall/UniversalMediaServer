package net.pms.util.jna;

public class IORegistryEntryTRef extends IOObjectTRef {

	public IORegistryEntryTRef() {
	}

	public IORegistryEntryTRef(boolean allocate) {
		super(allocate);
	}

	public IORegistryEntryTRef(IORegistryEntryT port) {
		super(port);
	}

	@Override
	public IORegistryEntryT getValue() {
		if (getPointer() == null) {
			return null;
		}
		return new IORegistryEntryT(getPointer().getNativeLong(0));
	}

}

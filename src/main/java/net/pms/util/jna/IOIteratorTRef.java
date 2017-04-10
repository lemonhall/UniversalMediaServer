package net.pms.util.jna;

public class IOIteratorTRef extends IOObjectTRef {

	public IOIteratorTRef() {
	}

	public IOIteratorTRef(boolean allocate) {
		super(allocate);
	}

	public IOIteratorTRef(IOIteratorT port) {
		super(port);
	}

	@Override
	public IOIteratorT getValue() {
		if (getPointer() == null) {
			return null;
		}
		return new IOIteratorT(getPointer().getNativeLong(0));
	}

}

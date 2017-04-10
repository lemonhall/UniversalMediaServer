package net.pms.util.jna;

public class IOServiceTRef extends MachPortTRef {

	public IOServiceTRef() {
	}

	public IOServiceTRef(boolean allocate) {
		super(allocate);
	}

	public IOServiceTRef(IOServiceT object) {
		super(object);
	}

	@Override
	public IOServiceT getValue() {
		if (getPointer() == null) {
			return null;
		}
		return new IOServiceT(getPointer().getNativeLong(0));
	}
}

package net.pms.util.jna;

public class IOObjectTRef extends MachPortTRef {

	public IOObjectTRef() {
		// TODO Auto-generated constructor stub
	}

	public IOObjectTRef(boolean allocate) {
		super(allocate);
		// TODO Auto-generated constructor stub
	}

	public IOObjectTRef(IOObjectT object) {
		super(object);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IOObjectT getValue() {
		if (getPointer() == null) {
			return null;
		}
		return new IOObjectT(getPointer().getNativeLong(0));
	}
}

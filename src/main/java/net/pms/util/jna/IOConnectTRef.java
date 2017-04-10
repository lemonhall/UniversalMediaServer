package net.pms.util.jna;


public class IOConnectTRef extends MachPortTRef {

	public IOConnectTRef() {
	}

	public IOConnectTRef(boolean allocate) {
		super(allocate);
	}

	public IOConnectTRef(IOConnectT port) {
		super(port);
	}

	@Override
	public IOConnectT getValue() {
		if (getPointer() == null) {
			return null;
		}
		return new IOConnectT(getPointer().getNativeLong(0));
	}
}

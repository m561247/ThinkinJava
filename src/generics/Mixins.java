package generics;

import java.util.Date;

interface TimeStamped {
	long getStamp();
}

class TimeStampedImp implements TimeStamped {
	private final long timeStamp;
	public TimeStampedImp() {
		timeStamp = new Date().getTime();
	}
	
	@Override
	public long getStamp() {
		return timeStamp;
	}
}

interface SerialNumbered {
	long getSerailNumber();
}

class SerialNumberedImp implements SerialNumbered {
	private static long counter = 1;
	private final long serialNumber = counter++;
	@Override
	public long getSerailNumber() {
		return serialNumber;
	}
}

interface Basic {
	public void set(String val);
	public String get();
}

class BasicImp implements Basic {
	private String value;
	public void set(String val) {
		value = val;
	}
	public String get() {
		return value;
	}
}

class Mixin extends BasicImp
implements TimeStamped, SerialNumbered {
	private TimeStamped timeStamp = new TimeStampedImp();
	private SerialNumbered serialNumber = new SerialNumberedImp();
	@Override
	public long getSerailNumber() {
		return serialNumber.getSerailNumber();
	}

	@Override
	public long getStamp() {
		return timeStamp.getStamp();
	}
}

public class Mixins {
	public static void main(String[] args) {
		Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
		mixin1.set("test string 1");
		mixin2.set("test string 2");
		System.out.println(mixin1.get() + " " + mixin1.getStamp() + " " + mixin1.getSerailNumber());
		System.out.println(mixin2.get() + " " + mixin2.getStamp() + " " + mixin2.getSerailNumber());
	}
}

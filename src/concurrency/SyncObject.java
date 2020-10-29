package concurrency;
import static net.mindview.util.Print.*;

class DualSynch {
	private Object syncObject = new Object();
	public synchronized void f() {
		for (int i = 0; i < 5000; i++) {
			print("f()");
			Thread.yield();
		}
	}
	public void g() {
		System.out.println(this);
		synchronized(this) {
			for (int i = 0; i < 5000; i++) {
				print("g()");
				Thread.yield();
			}
		}
	}
}

public class SyncObject {
	public static void main(String[] args) {
		final DualSynch ds = new DualSynch();
		new Thread() {
			public void run() {
				ds.f();
			}
		}.start();
		ds.g();
	}
}

package concurrency;
import java.util.concurrent.*;
import static net.mindview.util.Print.*;
// Daemon threads do'nt run the finally clause
class ADaemon implements Runnable {
	@Override
	public void run() {
		System.out.println("12121212");
		try {
			print("Starting ADaemon");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			print("Exiting via InterruptedException");
		} finally {
			print("This should always run?");
		}
	}
	
}

public class DaemonsDontRunFinally {
	public static void main(String[] args) {
		Thread t = new Thread(new ADaemon());
		t.setDaemon(false);
		t.start();
	}
}

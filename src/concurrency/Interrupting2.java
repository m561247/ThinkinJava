package concurrency;
// Interrupting a task blocked with a ReentrantLock.
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import static net.mindview.util.Print.*;

class BlockedkMutex {
	private Lock lock = new ReentrantLock();
	public BlockedkMutex() {
		// Acquire it right away, to demonstrate interruption
		// of a task blocked on a ReentrantLock: 
		lock.lock();
	}
	public void f() {
		try {
			// This will never be available to a second task
			lock.lockInterruptibly(); // Special call
			print("lock acquired in f()");
		} catch (InterruptedException e) {
			print("Interrupted from lock acquisition in f()");
		}
	}
}

class Blocked2 implements Runnable {
	BlockedkMutex blocked = new BlockedkMutex();
	@Override
	public void run() {
		print("Waiting for f()");
		blocked.f();
		print("Broken out of blocked call");
	}
	
}

public class Interrupting2 {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Blocked2());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Issuing t.interrupt()");
		t.interrupt();
	}
	
	
	
	
	
	
	
	
	
}

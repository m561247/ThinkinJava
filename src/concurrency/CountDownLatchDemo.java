package concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import static net.mindview.util.Print.*;
class TaskPortion implements Runnable {
	
	private static int counter = 0;
	private final int id = counter++;
	private static Random rand = new Random(47);
	private final CountDownLatch latch;
	TaskPortion(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		try {
			doWork();
			latch.countDown();
		} catch (InterruptedException ex) {
			//
		}
	}
	public void doWork() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
		print(this + "completed");
	}
	public String toString() {
		return String.format("%1$-3d", id);
	}
}

// Waits on the CountDownLatch
class WaitingTask implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final CountDownLatch latch;
	WaitingTask(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		try {
			latch.await();
			print("Latch barrier passed for " + this);
		} catch (InterruptedException ex) {
			print(this + " interrupted");
		}
	}
	
}

public class CountDownLatchDemo {

}

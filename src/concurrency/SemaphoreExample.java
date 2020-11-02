package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample implements Runnable {
	private int threadName;
	private Semaphore semaphore;

	public SemaphoreExample(int threadName, Semaphore semaphore) {
		this.semaphore = semaphore;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		try {
			this.semaphore.acquire();
			Thread.sleep(1000L);
			System.out.println("thread name is " + this.threadName);
			this.semaphore.release();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			exec.execute(new SemaphoreExample(i, semaphore));
		}
		exec.shutdown();
	}
}

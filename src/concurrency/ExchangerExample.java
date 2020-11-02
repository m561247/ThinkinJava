package concurrency;

import java.util.concurrent.Exchanger;

class ExchangeRunnable implements Runnable {
	Exchanger exchanger;
	Object object;
	
	public ExchangeRunnable(Exchanger exchanger, Object object) {
		this.exchanger = exchanger;
		this.object = object;
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Object previous = this.object;
				this.object = this.exchanger.exchange(this.object);
				System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
			}
		} catch (InterruptedException e) {
			
		}
	}
	
}

public class ExchangerExample {
	public static void main(String[] args) {
		Exchanger exchanger = new Exchanger();
		ExchangeRunnable ex1 = new ExchangeRunnable(exchanger, "A");
		ExchangeRunnable ex2 = new ExchangeRunnable(exchanger, "B");
		new Thread(ex1).start();
		new Thread(ex2).start();
	}
}

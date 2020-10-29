package concurrency;
// User interface responsiveness

import java.io.IOException;

class UnresponsiveUI {
	private volatile double d = 1;
	public UnresponsiveUI() throws IOException {
		while (d > 0) {
			d = d + (Math.PI + Math.E) / d;
		}
		System.in.read(); // Never gets here
	}
}
public class ResponsiveUI extends Thread {
	private static volatile double d = 1;
	public ResponsiveUI() {
		setDaemon(true);
		start();
	}
	public void run() {
		while (true) {
			d = d + (Math.PI + Math.E) / d;
		}
	}
	public static void main(String[] args) throws IOException {
		// ! new UnresponsiveUI(); // Must kill this process;
		new ResponsiveUI();
		System.in.read(); // Shows progress
		System.out.println(d);
	}
}

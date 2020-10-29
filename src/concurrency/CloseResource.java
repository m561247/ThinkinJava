package concurrency;
import java.net.*;
import java.util.concurrent.*;
import java.io.*;
import static net.mindview.util.Print.*;
public class CloseResource {
	public static void main(String[] args) throws IOException, InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		ServerSocket server = new ServerSocket(8081);
		InputStream socketInput = new Socket("localhost", 8081).getInputStream();
		exec.execute(new IOBlocked(socketInput));
		exec.execute(new IOBlocked(System.in));
		TimeUnit.MILLISECONDS.sleep(100);
		print("Shutting down all threads");
		exec.shutdownNow();
		TimeUnit.SECONDS.sleep(1);
		print("Closing " + socketInput.getClass().getName());
		socketInput.close(); // Releases blocked thread;
		TimeUnit.SECONDS.sleep(1);
		print("Closing " + System.in.getClass().getName());
		System.in.close(); // Releases blocked thread;
	}
}

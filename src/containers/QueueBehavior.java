package containers;

import java.util.*;
import java.util.concurrent.*;

import static net.mindview.util.Print.*;
import net.mindview.util.*;

public class QueueBehavior {
	private static int count = 10;
	static <T> void test(Queue<T> queue, Generator<T> gen) {
		for (int i = 0; i < count; i++) {
			queue.offer(gen.next());
		}
		while (queue.peek() != null) {
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}
	static class Gen implements Generator<String> {
		String[] s = ("one two three four five six seven " + "eight nine ten").split(" ");
		int i;
		@Override
		public String next() {
			return s[i++];
		}
	}
	public static void main(String[] args) {
		test(new LinkedList<String>(), new Gen()); // 按照加入順序排序
		test(new PriorityQueue<String>(), new Gen()); // 按照字串開頭字母 asc-ii code 排序
		test(new ArrayBlockingQueue<String>(count), new Gen()); // 
		test(new ConcurrentLinkedQueue<String>(), new Gen());
		test(new LinkedBlockingQueue<String>(), new Gen());
		test(new PriorityBlockingQueue<String>(), new Gen());
	}
}

package containers;
import java.util.*;
import static net.mindview.util.Print.*;
import net.mindview.util.Countries;
public class SortedSetDemo {
	public static void main(String[] args) {
		SortedSet<String> sortedSet = new TreeSet<>();
		Collections.addAll(sortedSet, "one two three four five six seven eitht".split(" "));
		print(sortedSet);
		String low = sortedSet.first();
		String high = sortedSet.last();
		print(low);
		print(high);
		Iterator<String> it = sortedSet.iterator();
		for (int i = 0; i <= 6; i++) {
			if (i == 3) {
				low = it.next();
				System.out.println("low = " + low);
			}
			if (i == 6) {
				high = it.next();
				System.out.println("high = " + high);
			}
			else {
				it.next();
			}
		}
		print(low);
		print(high);
		print(sortedSet.subSet(low, high));
		print(sortedSet.headSet(high));
		print(sortedSet.tailSet(low));
	}
}	

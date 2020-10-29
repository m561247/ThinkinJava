package containers;
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;
public class LinkedHashMapDemo {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(new CountingMapData(9));
		print(linkedMap);
		// Least-recently-used order
		linkedMap = new LinkedHashMap<>(16, 0.75f, true);
		linkedMap.putAll(new CountingMapData(9));
		print(linkedMap);
		for (int i = 0; i < 6; i++) {
			linkedMap.get(i); // 被 get 過後會被丟到最後面
		}
		print(linkedMap);
		linkedMap.get(0);
		print(linkedMap);
	}
}

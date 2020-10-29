package containers;
import java.util.*;
import net.mindview.util.*;
public class CollectionDataGeneration {
	public static void main(String[] args) {
		System.out.println(new ArrayList<String>(
				CollectionData.list(// Convenience method 
					new RandomGenerator.String(9), 10)));
		System.out.println(new HashSet<Integer>(
				new CollectionData<>(
					new  RandomGenerator.Integer(), 10)));
	}
	
}

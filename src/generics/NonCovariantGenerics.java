package generics;

import java.util.ArrayList;
import java.util.List;

public class NonCovariantGenerics {
	// Compiler Error : incompatible types
//	List<Fruit> flist = new ArrayList<Apple>();
	List<Fruit> flist = new ArrayList<>();
}

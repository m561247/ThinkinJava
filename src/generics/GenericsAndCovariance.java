package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
	public static void main(String[] args) {
		// Wildcards allow covariance
		List<? extends Fruit> flist = new ArrayList<Apple>();
		// Compiler error : can't add any type of object
//		flist.add(new Apple());
//		flist.add(new Fruit());
//		flist.add(new Object());
		
		
		
	}
	
	
}

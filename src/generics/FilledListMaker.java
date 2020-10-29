package generics;

import java.util.ArrayList;
import java.util.List;

public class FilledListMaker<T> { 
	List<T> create(T t, int n) {
		List<T> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			result.add(t);
		}
		return result;
	}
	public static void main(String[] args) {
		FilledListMaker<String> stringmaker = new FilledListMaker<>();
		List<String> list = stringmaker.create("Hello", 4);
		System.out.println(list);
	}
} 

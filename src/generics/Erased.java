package generics;

public class Erased<T> {
	private final int SIZE = 100;
//	public static void f(Object arg) {
//		if (arg instanceof T) {} // 錯誤，已宣告泛型情況下型態被 erase
//		T var = new T();
//		T[] array = new T[SIZE];
//		T[] array = (T) new Object[SIZE];
//	}
}

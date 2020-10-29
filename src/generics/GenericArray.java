package generics;

public class GenericArray<T> {
	private T[] array;
	public GenericArray(int sz) {
		array  =(T[]) new Object[sz];
	}
	public void put(int index, T item) {
		array[index] = item;
	}
	public T get(int index) {
		return array[index];
	}
	public T[] rep() {
		return array;
	}
}

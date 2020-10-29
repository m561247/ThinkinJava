package Interface;

public class TestRandVals {
	public static void main(String[] args) {
		// static 的情況，會在 load class 的時候就載入數值
		System.out.println(RandVals.RANDOM_FLOAT);
		System.out.println(RandVals.RANDOM_DOUBLE);
		System.out.println(RandVals.RANDOM_INT);
		System.out.println(RandVals.RANDOM_LONG);
	}
}

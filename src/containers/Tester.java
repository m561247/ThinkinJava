package containers;

import java.util.*;

public class Tester<C> {
	public static int fieldWidth = 8;
	public static TestParam[] defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 500);
	// Override this to modify pre-test initialization :
	protected C initialize(int size) {
		return container;
	}
	protected C container;
	private String headline = "";
	private List<Test<C>> tests;
	private static String stringField() {
		return "%" + fieldWidth + "d";
	}
	private static int sizeWidth = 5;
	private static String sizeField = "%" + sizeWidth + "s";
	private TestParam[] paramList = defaultParams;
	public Tester(C container, List<Test<C>> tests) {
		this.container = container;
		this.tests = tests;
		if (container != null) {
			headline = container.getClass().getSimpleName();
		}
	}
	public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
		this(container, tests);
		this.paramList = paramList;
	}
	public void setHeadline(String newHeadline) {
		
	}
}

package innerclasses;

abstract class Base {
	public Base(int i) {
		System.out.println("Base construct, i = " + i);
	}
	public abstract void f();
}

public class AnonymousConstrcutor {
	public static Base getBase(int i) { 
		return new Base(i) { // 省去再寫一個 class 去 implements 或 extends
			{System.out.println("Inside instance initializer");} // 要加上大括號
			@Override
			public void f() {
				System.out.println("In Anonymous f(0)");
			}
		};
	}
	public static void main(String[] args) {
		Base b = getBase(47);
		b.f();
	}
}

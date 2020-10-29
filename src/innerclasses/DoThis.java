package innerclasses;

public class DoThis {
	void f() {
		System.out.println("DoThis.f()");
	}
	public class Inner {
		public DoThis outer() {
			return DoThis.this; // 單純的 this 會指向 Inner
		}
	}
	public Inner inner() {
		return new Inner();
	}
	public static void main(String[] args) {
		DoThis dt = new DoThis();
		DoThis.Inner dti = dt.inner();
		dti.outer().f();
		System.out.println(dt);
		System.out.println(dti.outer());
	}
}

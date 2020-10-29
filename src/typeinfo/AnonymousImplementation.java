package typeinfo;

import typeinfo.interfacea.A;

class AnonymousA {
	public static A makeA() {
		return new A() {
			
			@Override
			public void f() {
				System.out.println("public C.f()");
			}
			public void g() {
				System.out.println("C.g()");
			}
			void u() {
				System.out.println("protected C.v()");
			}
			public void w() {
				System.out.println("private C.w()");
			}
			public void v() {
				System.out.println("public C.v()");
			}
		};
	}
}

public class AnonymousImplementation {
	public static void main(String[] args) throws Exception {
		A a = AnonymousA.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		// Reflection still gets into anonymous class
		HiddenImplementation.callHiddenMethod(a, "g");
		HiddenImplementation.callHiddenMethod(a, "u");
		HiddenImplementation.callHiddenMethod(a, "v");
		HiddenImplementation.callHiddenMethod(a, "w");
	}
}

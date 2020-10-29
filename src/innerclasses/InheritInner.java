package innerclasses;

class WithInner {
	class Inner {}
}

public class InheritInner extends WithInner.Inner {
	InheritInner(WithInner wi) { // 繼承內部類別的話這兩個不能少
		wi.super(); // 繼承內部類別的話這兩個不能少
	}
	public static void main(String[] args) {
		WithInner wi = new WithInner();
		InheritInner ii = new InheritInner(wi);
	}
}

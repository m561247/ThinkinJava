package generics;

class Automobile {}

public class Holder1 {
	private Automobile a;
	public Holder1(Automobile a) {
		this.a = a;
	}
	Automobile get() {
		System.out.println(Holder1.this);
		System.out.println(this);
		return a;
	}
	public static void main(String[] args) {
		Automobile a = new Automobile();
		Holder1 h = new Holder1(a);
		System.out.println(h.get());
	}
}

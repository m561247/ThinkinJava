package innerclasses;

public class Parcel7 {
	public Contents contents() {
		return new Contents() { // 匿名類別
			private int i = 11;
			public int value() {
				return i;
			}
		}; // 要加分號
	}
	public static void main(String[] args) {
		Parcel7 p = new Parcel7();
		Contents c = p.contents();
	}
}

package generics;

public class HijackedInterface {
	// compile error
//	class Cat extends ComparablePet implements Comparable<Cat> {
//		
//	}
	class Hamster extends ComparablePet implements Comparable<ComparablePet>{
		public int compareTo(ComparablePet arg) {
			return 0;
		}
	}
	class Gecko extends ComparablePet {
		public int compateTo(ComparablePet arg) {
			return 0;
		}
	}
}

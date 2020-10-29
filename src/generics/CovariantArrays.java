package generics;

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}


public class CovariantArrays {
	public static void main(String[] args) {
		Fruit[] fruit = new Apple[10];
		fruit[0] = new Apple();
		fruit[1] = new Jonathan();
		try {
			// Compiler allows you to add Fruit;
			fruit[0] = new Fruit();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			// Compiler allows you to add Oranges
			fruit[0] = new Orange();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

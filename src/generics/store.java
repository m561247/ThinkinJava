package generics;

class Product {
	private final int id;
	private String description;
	public Product(int IDnumber, String descr, double price) {
		this.description = descr;
		this.id = IDnumber;
		System.out.println(toString());
	}
}

public class store {

}

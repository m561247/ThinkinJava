package innerclasses;

public class Parcel10 {
	public Destination destination(final String dest, final float price) {
		return new Destination() {
			private int cost;
			// Instance initialization for each object
			{
				cost = Math.round(price);
				if (cost > 1000) {
					System.out.println("Over budget!");
				}
			}
			private String label;
			@Override
			public String readLabel() {
				// TODO Auto-generated method stub
				return label;
			}
		};
	}
	public static void main(String[] args) {
		Parcel10 p = new Parcel10();
		p.destination("123456", 10000f);
	}
}

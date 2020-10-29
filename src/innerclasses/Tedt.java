package innerclasses;

public class Tedt {
	
	public static void main(String[] args) {
		String s = "     111111111                            222222222222222         ";
		String[] s2 = s.split(" ");
		for (String e : s2) {
			if (!"".equals(e)) {
				System.out.println(e);
			}
		}
	}
}

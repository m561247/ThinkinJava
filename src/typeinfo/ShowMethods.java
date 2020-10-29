package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
	private static String usage = "usage:\n" +
			"ShowMethods qualified.class.name\n" +
			"To show all methods in class or:\n" +
			"ShowMethods qualified.class.name word\n" +
			"To search for methods involving ‘word’";
	private static String Shapes = "Shapes";
	private static Pattern p = Pattern.compile("\\w+\\.");
	public static void main(String[] args) throws ClassNotFoundException {
//		if (args.length < 1) {
//			System.out.println(usage);
//			System.exit(0);
//		}
		int lines = 0;
		Class<?> c = ShowMethods.class;
		Method[] methods = c.getMethods();
		Constructor[] ctors = c.getConstructors();
		if (args.length == 1) {
			for (Method method : methods) {
				System.out.println(p.matcher(method.toString()).replaceAll(" "));
			}
			lines = methods.length + ctors.length;
		} else {
			for (Method method : methods) {
					System.out.println(p.matcher(method.toString()).replaceAll(" "));
					lines++;
			}
			for (Constructor ctor : ctors) {
					System.out.println(p.matcher(ctor.toString()).replaceAll(" "));
					lines++;
			}
		}
	}
}	

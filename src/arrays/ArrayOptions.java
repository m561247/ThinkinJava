package arrays;

import java.util.*;
import static net.mindview.util.Print.*;

public class ArrayOptions {
	public static void main(String[] args) {
		BerylliumSphere[] a; // Local uninitialized variable
		BerylliumSphere[] b = new BerylliumSphere[5];
		// The reference inside the array are
		// automatically initialized to null
		print("b: " + Arrays.toString(b));

		BerylliumSphere[] c = new BerylliumSphere[4];
		for (int i = 0; i < c.length; i++) {
			if (c[i] == null) {
				c[i] = new BerylliumSphere();
			}
		}
		BerylliumSphere[] d = { new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere() };
		// Dynamic aggregate initialization
		a = new BerylliumSphere[] { new BerylliumSphere(), new BerylliumSphere() };
		print("a.length = " + a.length);
		print("b.length = " + b.length);
		print("c.length = " + c.length);
		print("d.length = " + d.length);

		// Array of primitives
		int[] e;
		int[] f = new int[5];
		print("f : " + Arrays.toString(f));
		int[] g = new int[4];
		for (int i = 0; i < g.length; i++) {
			g[i] = i * i;
		}
		
	}

}

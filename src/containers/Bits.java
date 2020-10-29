package containers;
import java.util.*;
import static net.mindview.util.Print.*;
public class Bits {
	public static void printBitSet(BitSet b) {
		print("bits: " + b);
		StringBuilder bbits = new StringBuilder();
		for (int j = 0; j < b.size(); j++) {
			bbits.append(b.get(j) ? "1" : "0");
		}
		print("bit pattern: " + bbits);
	}
	public static void main(String[] args) {
		Random rand = new Random(47);
		// Take the LSB of nextInt()
		byte bt = (byte) rand.nextInt();
		BitSet bb = new BitSet();
		for (int i = 7; i >= 0; i--) {
			if (((1 << i) & bt) != 0) {
				bb.set(i);
			} else {
				bb.clear(i);
			}
		}
		print("byte value: " + bt);
		printBitSet(bb);
		
		short st = (short) rand.nextInt();
		BitSet bs = new BitSet();
		for (int i = 15; i >= 0; i--) {
			if (((1 << i) & st) != 0) {
				
			}
		}
	}
}

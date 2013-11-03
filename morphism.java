import java.util.HashSet;
import java.util.Random;
/**Computes all morphisms of addition from GF(a) to GF(b). **/

public class morphism {
    static void morphism(int a, int b) {
	String[] carter = generate(a, b);
	cap: for (String c : carter) {
	    for (int k = 0; k < a; k++) {
		for (int l = 0; l < a; l++) {
		    for (int m = 0; m < a; m++) {
			int o = Integer.parseInt(c.substring(k, k + 1));
			int p = Integer.parseInt(c.substring(l, l + 1));
			int q = Integer.parseInt(c.substring(m, m + 1));
			if ((l + m) % b == k && (p + q) % b != o) {
			    continue cap;
			}
		    }
		}
	    }
	    System.out.println(c);
	}
    }
    static int power(int a, int b) {
	if (b == 0) {
	    return 1;
	} else {
	    return a * power(a, b - 1);
	}
    }
    /**Generates all the strings of length a of integers up to b.**/
    static String[] generate(int a, int b) {
	int w = 0;
	HashSet<String> q = new HashSet<String>();
	Random randy = new Random();
	String[] carter = new String[power(b, a-1)];
	while (w < power(b, a-1)) {
	    String s = "0";
	    for (int k = 1; k < a; k += 1) {
		s += "" + randy.nextInt(b);
	    }
	    if (!q.contains(s)) {
		q.add(s);
		w += 1;
	    }
	}
	w = 0;
	for (String kk : q) {
	    carter[w] = kk;
	    w += 1;
	}
	return carter;
    }
    public static void main(String[] args) {
	morphism(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }
}
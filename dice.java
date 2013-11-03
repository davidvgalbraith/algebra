import java.util.HashSet;
import java.util.Random;
/**Rolls five dice many times, computes how many rolls have three threes.**/
public class dice {
    public static void main(String[] args) {
	HashSet<String> x = new HashSet<String>();
	Random randy = new Random();
	while (x.size() < Math.pow(6, 5)) {
	    String y = "";
	    for (int k = 0; k < 5; k ++) {
		y += ("" + randy.nextInt(6));
	    }
	    System.out.println(y);
	    x.add(y);
	}
	int count = 0;
	for (String q : x) {
	    int aa = 0;
	    for (int a = 0; a < 5; a++) {
		String e = q.substring(a, a+1);
		if (e.equals("1")) {
		    aa += 1;
		}
	    }
	    if (aa == 3) {
		count += 1;
	    }
	}
	System.out.println(count);
	System.out.println(x.size());
    }
}
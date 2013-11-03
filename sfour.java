import java.util.HashSet;
/**Solves exercies 2.10.5.**/
public class sfour {
    private static String[] x;
    public static void main(String[] args) {
	x = new String[24];
	x[0] = "1234";
	x[1] = "1243";
	x[2] = "1324";
	x[3] = "1342";
	x[4] =  "1423";
	x[5] =  "1432";
	x[6] =  "2134";
	x[7] =  "2143";
	x[8] =  "2314";
	x[9] =  "2341";
	x[10] =  "2413";
	x[11] =  "2431";
	x[12] =  "3124";
	x[13] =  "3142";
	x[14] =  "3214";
	x[15] =  "3241";
	x[16] =  "3412";
	x[17] =  "3421";
	x[18] =  "4123";
	x[19] =  "4132";
	x[20] =  "4213";
	x[21] =  "4231";
	x[22] =  "4312";
	x[23] =  "4321";
	sfour();
    }
    static void sfour() {      
	HashSet<String> y = new HashSet<String>();
	y.add("1234");
	y.add("2143");
	y.add("3412");
	y.add("4321");
	for (String q : y) {
	    for (String r : x) {
		String c = apply(invert(r), apply(q, r));
		if (!y.contains(c)) {
		    //System.out.println("SHIITTT!!! SHIIIIIITTTTTTT!!!");
		}
	    }
	}
	for (String l : x) {
	    //System.out.println("The inverse of " + l + " is " + invert(l));
	}
	String[] xx = new String[3];
	xx[0] = "1234";
	xx[1] = "1342";
	xx[2] = "1423";
	for (String m :y) {
	    for (String n : xx)  {
		System.out.println(apply(m, n) + " LOLO");
	    }
	}
    }
    /**Applies x to y**/
    static String apply (String x, String y) {
	String a = y.substring(Integer.parseInt(x.substring(0, 1)) - 1, Integer.parseInt(x.substring(0, 1)));
	String b = y.substring(Integer.parseInt(x.substring(1, 2)) - 1, Integer.parseInt(x.substring(1, 2)));
	String c = y.substring(Integer.parseInt(x.substring(2, 3)) - 1, Integer.parseInt(x.substring(2, 3)));
	String d = y.substring(Integer.parseInt(x.substring(3, 4)) - 1, Integer.parseInt(x.substring(3, 4)));
	return a + b + c + d;
    }
    static String invert(String a) {
	for (String q : x) {
	    if (apply(q, a).equals("1234")) {
		return q;
	    }
	}
	return "This is bananas.";
    }
}
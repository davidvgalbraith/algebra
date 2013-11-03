import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
public class cube {
    private static HashMap<String, Integer> guide;
    public static void main(String[] args) {
	System.out.println("Adios.");
	cube();
    }
    /**A mystery.**/
    static void cube() {
	int[][] qq = generate(8);
	String[] x = new String[bang(8)];
	for (int a = 0; a < bang(8); a+=1) {
	    String c = "";
	    for (int b : qq[a]) {
		c += "" + b;
	    }
	    x[a] = c;
	}
	guide = new HashMap<String, Integer>();
	guide.put("12", 1);
	guide.put("13", 1);
	guide.put("14", 2);
	guide.put("15", 1);
	guide.put("16", 2);
	guide.put("17", 2);
	guide.put("18", 3);
	guide.put("23", 2);
	guide.put("24", 1);
	guide.put("25", 2);
	guide.put("26", 1);
	guide.put("27", 3);
	guide.put("28", 2);
	guide.put("34", 1);
	guide.put("35", 2);
	guide.put("36", 3);
	guide.put("37", 1);
	guide.put("38", 2);
	guide.put("45", 3);
	guide.put("46", 2);
	guide.put("47", 2);
	guide.put("48", 1);
	guide.put("56", 1);
	guide.put("57", 1);
	guide.put("58", 2);
	guide.put("67", 2);
	guide.put("68", 1); 
	guide.put("78", 1);
	ArrayList<String> w = new ArrayList<String>();
	for (String q : guide.keySet()) {
	    w.add(q);
	}
	for (String q : w) {
	    guide.put(new String(q.substring(1, 2) + q.substring(0,1)), guide.get(q));
	}
	stuff: for (String s : x) {
	    for (int a = 1; a < 9; a++) {	
		for (int b = 1; b < 9; b++) {
		    if (a != b) {
		    if (distance("" + a, "" + b, s) != guide.get(a + "" + b)) {
			continue stuff;
		    }
		    }
		}
	    }
	    System.out.println(s);
	}
    }
    /**Gives the distance between the given vertices in the given cube.**/
    static int distance(String x, String y, String cube) {
	int xp = cube.indexOf(x)+1;
	int yp = cube.indexOf(y)+1;
	try {
	return guide.get(xp + "" + yp);
	} catch (NullPointerException zz) {
	    System.out.println("Tried to get " + xp + yp + " and it all went straight to hell.");
	    System.exit(2);
	}
	return 3000;
    }
    static int bang(int n) {
	if (n == 0) {
	    return 1;
	} else {
	    return n * bang(n - 1);
	}
    }

    //ripped off the internet, not my code
    public static int[][] generate (int N) {
	// base case
	if (N == 2) {
	    return new int[][] {{1, 2}, {2, 1}};
	}
	else if (N > 2) {
	    // start with all permutations of previous degree
	    int[][] permutations = generate (N - 1);

	    for (int i = 0; i < factorial (N); i += N) {
		// copy each permutation N - 1 times
		for (int j = 0; j < N - 1; ++j) {
		    // similar to javascript's array.splice
		    permutations = insertRow (permutations, i, permutations [i]);
		}
	    }

	    // "weave" next number in
	    for (int i = 0, j = N - 1, d = -1; i < permutations.length; ++i) {
		// insert number N at index j
		// similar to javascript's array.splice
		permutations = insertColumn (permutations, i, j, N);

		// index j is  N-1, N-2, N-3, ... , 1, 0; then 0, 1, 2, ... N-1; then N-1, N-2, etc.
		j += d;

		// at beginning or end of the row, switch weave direction
		if (j < 0 || j > N - 1) {
		    d *= -1;
		    j += d;
		}
	    }
	    return permutations;
	} else {
	    throw new IllegalArgumentException ("N must be >= 2");
	}
    }

    private static void arrayDeepCopy (int[][] src, int srcRow, int[][] dest,
				       int destRow, int numOfRows) {
	for (int row = 0; row < numOfRows; ++row) {
	    System.arraycopy (src [srcRow + row], 0, dest [destRow + row], 0,
			      src[row].length);
	}
    }

    public static int factorial (int n) {
	return n == 1 ? 1 : n * factorial (n - 1);
    }

    private static int[][] insertColumn (int[][] src, int rowIndex,
					 int columnIndex, int columnValue) {
	int[][] dest = new int[src.length][0];
	for (int i = 0; i < dest.length; ++i) {
	    dest [i] = new int [src[i].length];
	}
	arrayDeepCopy (src, 0, dest, 0, src.length);
	int numOfColumns = src[rowIndex].length;
	int[] rowWithExtraColumn = new int [numOfColumns + 1];
	System.arraycopy (src [rowIndex], 0, rowWithExtraColumn, 0, columnIndex);
	System.arraycopy (src [rowIndex], columnIndex, rowWithExtraColumn,
			  columnIndex + 1, numOfColumns - columnIndex);
	rowWithExtraColumn [columnIndex] = columnValue;
	dest [rowIndex] = rowWithExtraColumn;
	return dest;
    }

    private static int[][] insertRow (int[][] src, int rowIndex,
				      int[] rowElements) {
	int srcRows = src.length;
	int srcCols = rowElements.length;
	int[][] dest = new int [srcRows + 1][srcCols];
	arrayDeepCopy (src, 0, dest, 0, rowIndex);
	arrayDeepCopy (src, rowIndex, dest, rowIndex + 1, src.length - rowIndex);
	System.arraycopy (rowElements, 0, dest [rowIndex], 0, rowElements.length);
	return dest;
    }
}
/**Finds the cosets in the dihedral group.**/
public class dihedral {
    public static void main(String[] args) {
	int n = Integer.parseInt(args[0]);
	int r = Integer.parseInt(args[1]);
	int d = Integer.parseInt(args[2]);
	for (int k = 0; k < 2; k++) {
	    for (int l = 0; l < n; l++) {
		int[] inv = inverse(n, l, k);
		System.out.println(simplify(n, inv[0], inv[1], r, d, l, k));
	    }
	}
    }
    static String simplify(int n, int rone, int done, int rtwo, int dtwo, int rthree, int dthree) {
	if (done == 0) {
	    rone = (rone + rtwo) % n;
	    if (dtwo == 0) {
		rone = (rone + rthree) % n;
		return "R" + rone + "D" + dthree;
	    } else {
		while (rthree > 0) {
		    rone = (rone + n - 1) % n;
		    rthree -= 1;
		}
		dtwo = (dtwo + dthree) % 2;
		return "R" + rone + "D" + dtwo;
	    }
	} else {
	    while (rtwo > 0) {
		rone = (rone + n - 1) % n;
		rtwo -= 1;
	    }
	    done = (done + dtwo) % 2;
	    if (done > 0) {
		while (rthree > 0) {
		    rone = (rone + n - 1) % n;
		    rthree -= 1;
		}
		done = (done + dthree) % 2;
		return "R" + rone + "D" + done;
	    } else {
		rone = (rone + rthree) % n;
		return "R" + rone + "D" + dthree;
	    }
	}
    }
    static int[] inverse(int n, int r, int d) {
	int[] ans = new int[2];
	if (d == 0) {
	    ans[0] = n - r;
	    ans[1] = 0;
	    return ans;
	}
	ans[0] = r;
	ans[1] = d;
	return ans;
    }
}
import java.util.HashSet;
import java.util.Set;

class P5568 {

    private static Set<Integer> set;
    private static int[] cards;
    private static int n, k;

    public static void main(String[] args) throws Exception {
        n = read();
        k = read();
        cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = read();
        }
        
        set = new HashSet<>();
        perm(0, 0, 0);

        System.out.print(set.size());
    }

    private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		if (c == 13) {
			System.in.read();
		}
		
		return n;
	}

    private static void perm(int depth, int curr, int mask) {
        if (depth == k) {
            set.add(curr);
            return;
        }

        for (int i = 0; i < n; i++) {
            if ((mask & 1 << i) != 0) {
                continue;
            }

            perm(depth + 1, (cards[i] > 9 ? curr * 100 : curr * 10) + cards[i], mask | 1 << i);
        }
    }
}

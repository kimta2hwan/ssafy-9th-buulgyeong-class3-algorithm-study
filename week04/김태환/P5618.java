import java.util.TreeSet;

class P5618 {
	public static void main(String[] args) throws Exception {
		int n = read();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = read();
		}
		
		int gcdNumber = gcd(arr[0], arr[1]);
		
		if (n == 3) {
			gcdNumber = gcd(gcdNumber, arr[2]);
		}
		
		StringBuilder sb = new StringBuilder();
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		for (int i = 1; i <= Math.sqrt(gcdNumber); i++) {
			if (gcdNumber % i == 0) {
				treeSet.add(gcdNumber / i);
				treeSet.add(i);
			}
		}
		
		while (!treeSet.isEmpty()) {
			sb.append(treeSet.pollFirst()).append('\n');
		}
		
		System.out.println(sb);
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
	
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}

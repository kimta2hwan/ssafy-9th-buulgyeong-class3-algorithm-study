class P21920 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = read();
		}
		
		int X = read();
		int count = 0;
		long sum = 0;
		
		for (int i : arr) {
			if (gcd(i, X) == 1) {
				sum += i;
				count++;
			}
		}
		
		System.out.println((float)sum / (float)count);
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

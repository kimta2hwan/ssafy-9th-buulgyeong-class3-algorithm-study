class P11047 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int K = read();
		
		int[] coins = new int[N];
		
		for (int i = 0; i < N; i++) {
			coins[i] = read();
		}
		
		int count = 0;
		
		for (int i = N - 1; i >= 0; i--) {
			while (coins[i] <= K) {
				count += K / coins[i];
				K %= coins[i];
			}
		}
		
		System.out.println(count);
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
}

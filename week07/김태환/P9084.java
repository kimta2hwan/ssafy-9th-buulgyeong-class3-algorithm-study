class P9084 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int T = read();
		
		while (T-- > 0) {
			int N = read();
			int[] coins = new int[N];
			
			for (int i = 0; i < N; i++) {
				coins[i] = read();
			}
			
			int M = read();
			int[] dp = new int[M + 1];
			dp[0] = 1;
			
			for (int coin : coins) {
				for (int i = coin; i <= M; i++) {
					dp[i] += dp[i - coin];
				}
			}
			
			sb.append(dp[M]).append('\n');
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
}

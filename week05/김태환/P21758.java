class P21758 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = read();
			dp[i] = dp[i - 1] + arr[i];
		}
		
		int answer = 0;
		
		for (int i = 2; i < N; i++) {
			answer = Math.max(answer, dp[N] - arr[1] - arr[i] + dp[N] - dp[i]);
			answer = Math.max(answer, dp[N] - arr[N] - arr[i] + dp[i - 1]);
			answer = Math.max(answer, dp[i] - arr[1] + dp[N] - dp[i - 1] - arr[N]);
		}
		
		System.out.println(answer);
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

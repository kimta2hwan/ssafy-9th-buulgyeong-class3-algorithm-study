import java.util.Arrays;

class P2839 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int[] dp = new int[N + 1];
		
		Arrays.fill(dp, 5000);
		dp[0] = 0;
		
		for (int i = 1; i <= N; i++) {
			if (i >= 5) {
				dp[i] = Math.min(dp[i], dp[i - 5] + 1);
			}
			
			if (i >= 3) {
				dp[i] = Math.min(dp[i], dp[i - 3] + 1);
			}
		}
		
		System.out.println(dp[N] == 5000 ? -1 : dp[N]);
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

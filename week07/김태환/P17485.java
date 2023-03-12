class P17485 {

    private static int M;

    public static void main(String[] args) throws Exception {
        int N = read();
        M = read();

        int[][][] dp = new int[3][N][M];
        int[][] fuel = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                fuel[i][j] = read();
            }
        }

        for (int i = 0; i < M; i++) {
            dp[0][0][i] = fuel[0][i];
            dp[1][0][i] = fuel[0][i];
            dp[2][0][i] = fuel[0][i];
        }

        for (int i = 0; i < N; i++) {
            dp[0][i][0] = Integer.MAX_VALUE;
            dp[2][i][M - 1] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isPossible(j - 1) && isPossible(j + 1)) {
                    dp[0][i][j] = Math.min(dp[1][i - 1][j - 1], dp[2][i - 1][j - 1]) + fuel[i][j];
                    dp[1][i][j] = Math.min(dp[0][i - 1][j], dp[2][i - 1][j]) + fuel[i][j];
                    dp[2][i][j] = Math.min(dp[0][i - 1][j + 1], dp[1][i - 1][j + 1]) + fuel[i][j];

                } else if (!isPossible(j - 1) && isPossible(j + 1)) {
                    dp[1][i][j] = Math.min(dp[0][i - 1][j], dp[2][i - 1][j]) + fuel[i][j];
                    dp[2][i][j] = Math.min(dp[0][i - 1][j + 1], dp[1][i - 1][j + 1]) + fuel[i][j];

                } else if (isPossible(j - 1) && !isPossible(j + 1)) {
                    dp[0][i][j] = Math.min(dp[1][i - 1][j - 1], dp[2][i - 1][j - 1]) + fuel[i][j];
                    dp[1][i][j] = Math.min(dp[0][i - 1][j], dp[2][i - 1][j]) + fuel[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                if (dp[j][N - 1][i] < min) {
                    min = dp[j][N - 1][i];
                }
            }
        }

        System.out.println(min);
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

    private static boolean isPossible(int c) {
        if (c < 0 || c >= M) {
            return false;
        }

        return true;
    }
}

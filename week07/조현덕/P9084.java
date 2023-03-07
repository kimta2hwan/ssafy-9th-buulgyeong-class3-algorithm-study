import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9084 {

	static int T, N, M;
	static int[] coin;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			coin = new int[N + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());

			dp = new int[N + 1][M + 1];

			for (int i = 1; i <= N; i++) {
				int value = coin[i];
				for (int j = 1; j <= M; j++) {
					if (j - value > 0) {
						dp[i][j] = dp[i - 1][j] + dp[i][j - value];
					} else if (j - value == 0) {
						dp[i][j] = dp[i - 1][j] + 1;
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}

			System.out.println(dp[N][M]);
		}
	}

}

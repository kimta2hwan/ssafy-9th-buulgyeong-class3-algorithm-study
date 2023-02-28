import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21317 {

    static int N, K;
    static int[] small, big;


    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        small = new int[N];
        big = new int[N];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            small[i] = Integer.parseInt(st.nextToken());
            big[i] = Integer.parseInt(st.nextToken());
        }
        K = Integer.parseInt(br.readLine());
    }

    static void solve() {
        int[][] dp = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < 2; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + small[i]);
                if (i < N - 2) dp[i + 2][j] = Math.min(dp[i + 2][j], dp[i][j] + big[i]);
                if (i < N - 3 && j == 0) dp[i + 3][j + 1] = Math.min(dp[i + 3][j], dp[i][j] + K);
            }
        }

        System.out.println(Math.min(dp[N - 1][0], dp[N - 1][1]));
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P22857 {

    static int N, K;
    static int[] S;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        S = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int[][] dp = new int[N][K + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][0] = (S[i] % 2 == 0 ? 1 : 0);
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j <= K; j++) {
                if (dp[i][j] == -1) continue;
                if (S[i + 1] % 2 == 0) dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + 1);
                else if (j < K)        dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {           // try 1) WA. 정답은 dp 배열 전체에서 찾아야 한다
            for (int j = 0; j <= K; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}

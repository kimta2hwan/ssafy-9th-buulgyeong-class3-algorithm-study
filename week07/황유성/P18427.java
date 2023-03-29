import java.io.*;
import java.util.*;

public class P18427 {

    static int N, M, H;
    static int[][] blocks;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        blocks = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                int h = Integer.parseInt(st.nextToken());
                if (h <= H) blocks[i][j++] = h;
            }
        }
    }

    static void solve() {
        final int MOD = 10_007;
        // dp[i][j]: i번째 학생까지 고려했을 때 높이가 j인 탑을 만드는 경우의 수
        int[][] dp = new int[N][H + 1];
        dp[0][0] = 1;
        for (int h : blocks[0]) {
            dp[0][h] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int h : blocks[i]) {
                if (h == 0) break;
                for (int j = h; j <= H; j++) {
                    dp[i][j] += dp[i - 1][j - h];
                }
            }
            for (int j = 0; j <= H; j++) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
            }
        }

        System.out.println(dp[N - 1][H]);
    }
}

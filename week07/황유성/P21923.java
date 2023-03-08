import java.util.*;
import java.io.*;

public class P21923 {

    static int N, M;
    static int[][] score;
    static long[][] ldp, rdp;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        score = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        ldp = new long[N][M];
        rdp = new long[N][M];

        makeDP(ldp, 0, 1);
        makeDP(rdp, M - 1, -1);

        long answer = Long.MIN_VALUE;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                answer = Math.max(answer, ldp[r][c] + rdp[r][c]);
            }
        }

        System.out.println(answer);
    }

    static void makeDP(long[][] dp, int s, int d) {
        dp[N - 1][s] = score[N - 1][s];
        for (int r = N - 2; r >= 0; r--) {
            dp[r][s] = dp[r + 1][s] + score[r][s];
        }
        for (int c = s + d; 0 <= c && c < M; c += d) {
            dp[N - 1][c] = dp[N - 1][c - d] + score[N - 1][c];
        }

        for (int c = s + d; 0 <= c && c < M; c += d) {
            for (int r = N - 2; r >= 0; r--) {
                dp[r][c] = Math.max(dp[r + 1][c], dp[r][c - d]) + score[r][c];
            }
        }
    }
}

import java.io.*;
import java.util.*;

public class P1823 {

    /**
     * dp[i][j]: 왼쪽 벼를 i번 인덱스까지, 오른쪽 벼를 j번 인덱스까지 수확했을 때 얻을 수 있는 최대 이익
     * i + 1번 인덱스의 벼를 수확하고 dp[i + 1][j]로 전이하거나
     * j - 1번 인덱스의 벼를 수확하고 dp[i][j - 1]로 전이할 수 있다
     * bottom-up으로 구현하려면 인덱스 처리가 번거로우므로
     * top-down으로 접근해보자.
     *
     * dp[l][r]은 dp[l - 1][r]에서 l번 인덱스의 벼를 수확한 것과
     *           dp[l][r + 1]에서 r번 인덱스의 벼를 수확한 것 중 최댓값이 전이된 것이다
     * 따라서 dp[l][r] = max(V[l] * k + dp[l - 1][r], V[r] * k + dp[l][r + 1])
     * 이때 k = l - r + N + 1 이 성립한다
     */
    static int N;
    static int[] V;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        V = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        dp = new int[N + 2][N + 2];
        int answer = 0;
        for (int l = 0; l <= N; l++) {
            answer = Math.max(answer, calc(l, l + 1));
        }

        System.out.println(answer);
    }

    static int calc(int l, int r) {
        if (l == 0 && r == N + 1) return 0;
        if (dp[l][r] != 0) return dp[l][r];
        int k = l - r + N + 1;
        int ret = 0;
        if (l > 0) ret = Math.max(ret, V[l] * k + calc(l - 1, r));
        if (r <= N) ret = Math.max(ret, V[r] * k + calc(l, r + 1));
        return dp[l][r] = ret;
    }
}
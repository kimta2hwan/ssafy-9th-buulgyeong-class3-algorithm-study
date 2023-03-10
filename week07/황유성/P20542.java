import java.io.*;
import java.util.*;

public class P20542 {
    /*

     *          *    t a k e n
     *          *''  1 2 3 4 5
     *          * f  1 2 3 4 5
     *          * i  2 2 3 4 5
     *          * s  3 3 3 4 5
     *          * h  4 4 4 4 5
     *          * c  5 5 5 5 5
     *          * a  6 5 6 6 6
     *          * k  7 7 5 6 7
     *          * e  8 8 8 5 6
     *          ans = 6
     *

                 *
                 *    p i z a
                 *''  1 2 3 4
                 * p  0
                 * i    0
                 * z      0
                 * z        1
                 * a
                 * a
     * 1. 입력 제한을 보니 O(NM) 풀이가 가능하다
     * 2. dp[i][j]: 정답의 i번째 문자까지 완성하는데 마지막에 답안의 j번째 문자를 사용할 때 점수의 최솟값
     * 3. dp[0]에는 빈 문자열을 넣고 비교할 것이므로, 정답은 dp[M][N - 1]
     */

    static int n, m;
    static char[] A, B;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();
    }

    static void solve() {
        dp = new int[m + 1][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = j + 1;
        }
        dp[1][0] = (match(A[0], B[0]) ? 0 : 1);
        for (int i = 2; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + (match(A[0], B[i - 1]) ? 0 : 1);
        }
        for (int j = 1; j < n; j++) {
            for (int i = 1; i <= m; i++) {
                int scoreAdd = match(A[j], B[i - 1]) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j - 1] + scoreAdd, dp[i][j - 1] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + scoreAdd + 1);
            }
        }

        System.out.println(dp[m][n - 1]);
    }

    static boolean match(char a, char b) {
        if (a == b) return true;
        if (a == 'i') {
            return b == 'j' || b == 'l';
        }
        if (a == 'v') {
            return b == 'w';
        }
        return false;
    }
}

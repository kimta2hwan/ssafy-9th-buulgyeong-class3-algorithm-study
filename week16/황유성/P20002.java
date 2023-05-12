import java.io.*;
import java.util.*;

public class P20002 {

    static int N;
    static int[][] profit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        profit = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                profit[i][j] = Integer.parseInt(st.nextToken()) +
                        profit[i - 1][j] + profit[i][j - 1] - profit[i - 1][j - 1];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= i && k <= j; k++) {
                    int si = i - k;
                    int sj = j - k;
                    int curProfit = profit[i][j] - profit[si][j] - profit[i][sj] + profit[si][sj];
                    answer = Math.max(answer, curProfit);
                }
            }
        }
        System.out.println(answer);
    }
}

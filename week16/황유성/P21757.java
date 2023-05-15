import java.io.*;
import java.util.*;

public class P21757 {

    static int N;
    static long answer;
    static int[] A;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 4개의 부분합은 각각 intervalSum = sum / 4 가 되어야 한다
        // 2. 왼쪽 원소부터 N-2 번째 원소까지 iteration 하면서 누적합을 만들어 가는 과정에서 (intervalSum * k)가 나타날 때마다
        //     dp[k] += dp[k - 1]
        // 3. iteration 을 종료했을 때 dp[3]의 값이 정답이다.

        for (int i = 1; i < N; i++) {
            A[i] += A[i - 1];
        }
        int itvSum = A[N - 1] / 4;
        if (itvSum == 0) {
            long zeroCnt = 0L;
            for (int i = 0; i < N - 1; i++) {
                if (A[i] == 0L) zeroCnt++;
            }
            answer = zeroCnt * (zeroCnt - 1) * (zeroCnt - 2) / 6;
        } else {
            dp = new long[4];
            dp[0] = 1L;
            for (int i = 0; i < N - 1; i++) {
                for (int k = 1; k <= 3; k++) {
                    if (A[i] == k * itvSum) {
                        dp[k] += dp[k - 1];
                        break;
                    }
                }
            }
            answer = dp[3];
        }
        System.out.println(answer);
    }
}

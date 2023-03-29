import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. 자기 턴에 돌이 1개 또는 3개 남으면 이긴다
 * 2. 자기 턴에 돌이 2개 남으면 진다
 * 3. n에서 1 또는 3을 차감하고 함수를 호출하면 상대 턴과 같다
 * 4. 1차감과 3차감 중 상대 턴에 대한 win 함수의 호출 결과가 false인 것이 최적 선택이다
 * 5. 메모이제이션으로 최적화하자.
 */
public class P9655 {

    static int N;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N + 1];
        Arrays.fill(dp, -1);

        boolean winSK = win(N);
        System.out.println(winSK ? "SK" : "CY");
    }

    static boolean win(int n) {
        if (dp[n] != -1) return dp[n] == 1;
        if (n == 1 || n == 3) return true;
        if (n == 2) return false;
        dp[n] = (!win(n - 1) || !win(n - 3)) ? 1 : 0;
        return dp[n] == 1;
    }
}

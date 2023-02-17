import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2553_마지막팩토리얼수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[20001];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 6;
        dp[4] = 4;

        for (int i = 5; i <= N; i++) {
            if (i % 5 == 0) {
                int q = i / 5;
                dp[i] = ((int) Math.pow(2, q % 4) * dp[q]) % 10; // 공식 사용.
            } else {
                int before = (i / 5) * 5; // i보다 작은 최대 5의 배수를 구함.
                int total = 1;
                for (int j = i; j > before; j--) {
                    total *= (j % 10);
                }
                total *= dp[before];
                dp[i] = total % 10;
            }
        }
        System.out.println(dp[N]);
    }

}
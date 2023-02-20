import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.LongStream;

/**
 * 팁을 적게 주는 손님일수록 뒤에 배치한다면, 팁 차감액을 최소화할 수 있다
 */

public class P1758 {

    static int N, discount;
    static long[] tip;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tip = new long[N];
        for (int i = 0; i < N; i++) {
            tip[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        discount = N - 1;
        long answer = LongStream.of(tip).sorted().map(e -> discountedTip(e)).sum();
        System.out.println(answer);
    }

    static long discountedTip(long tip) {
        return Math.max(tip - discount--, 0);
    }
}

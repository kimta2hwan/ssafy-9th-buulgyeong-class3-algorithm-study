import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class P11508 {

    static int N, cnt;
    static int[] C;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        C = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        cnt = N;
        int ans = IntStream.of(C).sorted().filter(e -> isPayed()).sum();
        System.out.println(ans);
    }

    static boolean isPayed() {
        return cnt-- % 3 != 0;
    }
}

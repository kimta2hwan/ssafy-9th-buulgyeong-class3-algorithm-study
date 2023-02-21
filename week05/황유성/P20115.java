import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 가장 많은 양의 드링크에 다 몰아주기
 */
public class P20115 {

    static int N;
    static double[] x;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        x = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        Arrays.sort(x);
        double ans = x[N - 1];
        ans += Arrays.stream(x, 0, N - 1).map(e -> e / 2).sum();
        System.out.println(ans);
    }
}

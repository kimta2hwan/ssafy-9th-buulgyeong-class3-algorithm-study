import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P11053 {

    static int N;
    static int[] A;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int[] dp = new int[N];
        Arrays.fill(dp, 1); // try 4) dp 배열 초기값 오류

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            // try 1, 2, 3) 잘못된 점화식
        }

        int ans = IntStream.of(dp).max().orElse(1);
        System.out.println(ans);
    }
}

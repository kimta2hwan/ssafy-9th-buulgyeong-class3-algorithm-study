import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. N이 짝수일 때에는 근손실이 최소인 운동기구와 최대인 운동기구를 짝짓는 것이 항상 최적이다
 * 2. N이 홀수일 때에는 근손실이 최대인 운동기구를 빼놓고 1의 작업을 한다
 */
public class P20300 {

    static int N;
    static long[] t;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        t = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            t[i] = Long.parseLong(st.nextToken());
        }
    }

    static void solve() {
        Arrays.sort(t);
        long ans = 0L;
        int halfSize = t.length / 2;
        if (N % 2 == 0) {
            for (int i = 0; i < halfSize; i++) {
                ans = Math.max(ans, t[i] + t[N - 1 - i]);
            }
        } else {
            ans = t[t.length - 1];
            for (int i = 0; i < halfSize - 1; i++) {
                ans = Math.max(ans, t[i] + t[N - 2 - i]);
            }
        }
        System.out.println(ans);
    }
}

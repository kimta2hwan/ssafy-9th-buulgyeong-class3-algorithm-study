import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P22869 {

    static int N, K;
    static int[] A;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        boolean[] visit = new boolean[N];
        visit[0] = true;
        for (int i = 0; i < N - 1; i++) {
            if (!visit[i]) continue;

            for (int j = i + 1; j < N; j++) {
                if ((j - i) * (1 + Math.abs(A[i] - A[j])) <= K) {
                    visit[j] = true;
                }
            }
        }

        System.out.println(visit[N - 1] ? "YES" : "NO");
    }
}

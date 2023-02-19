import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P22864 {

    static int A, B, C, M;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        int fatigue = 0, work = 0;
        for (int i = 0; i < 24; i++) {
            if (fatigue + A <= M) {
                fatigue += A;
                work += B;
            } else {
                fatigue = Math.max(fatigue - C, 0);
            }
        }
        System.out.println(work);
    }
}

import java.io.*;
import java.util.*;

public class P2428 {

    static int N;
    static int[] F;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        F = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            F[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        Arrays.sort(F);

        long answer = 0;
        int lp = 0, rp = 1;
        while (lp < N) {
            while (rp < N && F[lp] >= 0.9 * F[rp]) rp++;
            answer += rp - lp - 1;
            lp++;
        }

        System.out.println(answer);
    }
}

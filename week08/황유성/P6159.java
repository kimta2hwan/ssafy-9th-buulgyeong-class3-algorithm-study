import java.io.*;
import java.util.*;

public class P6159 {

    static int N, S;
    static int[] L;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        L = new int[N];
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        Arrays.sort(L);

        int answer = 0;
        int lp = 0, rp = N - 1;
        while (lp < rp) {
            int sum = L[lp] + L[rp];
            if (sum <= S) {
                answer += (rp - lp);
                lp++;
            } else {
                rp--;
            }
        }
        System.out.println(answer);
    }
}

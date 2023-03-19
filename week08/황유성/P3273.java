import java.io.*;
import java.util.*;

public class P3273 {

    static int n, x;
    static int[] seq;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        seq = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
    }

    static void solve() {
        Arrays.sort(seq);
        int s = -1;
        for (int i = 0; i < seq.length - 1; i++) {
            if (seq[i] + seq[i + 1] <= x) s = i;
        }
        int lp = s, rp = s + 1;
        int answer = 0;
        while (0 <= lp && rp < seq.length) {
            int sum = seq[lp] + seq[rp];
            if (sum > x) {
                lp--;
            } else {
                if (sum == x) answer++;
                rp++;
            }
        }
        System.out.println(answer);
    }
}

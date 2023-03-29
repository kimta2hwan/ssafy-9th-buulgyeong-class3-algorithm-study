import java.util.*;
import java.io.*;

public class P2531 {

    static int N, d, k, c;
    static int[] dishes, counts;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dishes = new int[N + k - 1];
        for (int i = 0; i < N; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        for (int i = N; i < dishes.length; i++) {
            dishes[i] = dishes[i - N];
        }

        int kindNum = 0;
        counts = new int[d + 1];
        for (int i = 0; i < k; i++) {
            if (++counts[dishes[i]] == 1) kindNum++;
        }
        int answer = kindNum + (counts[c] == 0 ? 1 : 0);
        for (int i = k; i < dishes.length; i++) {
            if (++counts[dishes[i]] == 1) kindNum++;
            if (--counts[dishes[i - k]] == 0) kindNum--;
            answer = Math.max(answer, kindNum + (counts[c] == 0 ? 1 : 0));
        }

        System.out.println(answer);
    }
}

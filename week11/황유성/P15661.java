import java.io.*;
import java.util.*;

public class P15661 {

    static int N, answer;
    static int[][] stat;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stat = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        answer = Integer.MAX_VALUE;
        subset(0, 0, 0, 0);
        System.out.println(answer);
    }

    static void subset(int idx, int diff, int start, int link) {
        if (idx == N) {
            if (start == 0 || link == 0) return;
            answer = Math.min(answer, Math.abs(diff));
            return;
        }

        int nextDiff = diff;
        for (int i = 0; i < N; i++) {
            if ((start & (1 << i)) != 0) {
                nextDiff += stat[idx][i] + stat[i][idx];
            }
        }
        subset(idx + 1, nextDiff, start | (1 << idx), link);

        nextDiff = diff;
        for (int i = 0; i < N; i++) {
            if ((link & (1 << i)) != 0) {
                nextDiff -= stat[idx][i] + stat[i][idx];
            }
        }
        subset(idx + 1, nextDiff, start, link | (1 << idx));
    }
}

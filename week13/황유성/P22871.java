import java.io.*;
import java.util.*;

public class P22871 {

    static int N;
    static long[] A;
    static long[][] cost;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        cost = new long[N][N];
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                cost[i][j] = (j - i) * (1 + Math.abs(A[i] - A[j]));
            }
        }

        int left = 0;
        int right = 1_000_000;
        while (left <= right) {
            int mid = (left + right) >> 1;

            if (able(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    static boolean able(int limit) {
        boolean[] visit = new boolean[N];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offerLast(0);
        while (!q.isEmpty()) {
            int cur = q.pollFirst();

            for (int nex = cur + 1; nex < N; nex++) {
                if (cost[cur][nex] > limit || visit[nex]) continue;
                if (nex == N - 1) return true;
                q.offerLast(nex);
                visit[nex] = true;
            }
        }
        return false;
    }
}

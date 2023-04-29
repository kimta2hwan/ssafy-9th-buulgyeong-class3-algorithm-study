import java.io.*;
import java.util.*;

public class P14712 {

    static int N, M, limit, answer;
    static boolean[][] nemo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nemo = new boolean[N + 1][M + 1];

        limit = N * M;
        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == limit) {
            answer++;
            return;
        }

        int r = (depth / M) + 1;
        int c = (depth % M) + 1;

        if (!(nemo[r - 1][c - 1] && nemo[r][c - 1] && nemo[r - 1][c])) {
            nemo[r][c] = true;
            dfs(depth + 1);
            nemo[r][c] = false;
        }
        dfs(depth + 1);
    }
}

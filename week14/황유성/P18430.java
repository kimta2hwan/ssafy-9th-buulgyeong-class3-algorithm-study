import java.io.*;
import java.util.*;

public class P18430 {

    static int N, M, limit, answer;
    static int[][] grid;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N + 2][M + 2];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= M; c++) {
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        limit = N * M;

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int sum) {
        if (depth == limit) {
            answer = Math.max(answer, sum);
            return;
        }

        dfs(depth + 1, sum);
        int r = depth / M + 1;
        int c = depth % M + 1;
        if (grid[r][c] == 0) return;
        int temp0 = grid[r][c];
        for (int d1 = 0; d1 < 4; d1++) {
            int nr1 = r + dr[d1];
            int nc1 = c + dc[d1];
            if (grid[nr1][nc1] == 0) continue;

            int d2 = (d1 + 1) % 4;
            int nr2 = r + dr[d2];
            int nc2 = c + dc[d2];
            if (grid[nr2][nc2] == 0) continue;

            int temp1 = grid[nr1][nc1];
            int temp2 = grid[nr2][nc2];
            grid[r][c] = grid[nr1][nc1] = grid[nr2][nc2] = 0;

            dfs(depth + 1, sum + 2 * temp0 + temp1 + temp2);

            grid[r][c] = temp0;
            grid[nr1][nc1] = temp1;
            grid[nr2][nc2] = temp2;
        }
    }
}

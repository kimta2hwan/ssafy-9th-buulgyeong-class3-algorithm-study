import java.io.*;
import java.util.*;

public class P21922 {

    static class Node {
        int r, c, d;

        Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static int N, M;
    static int[][] grid;

    // 0: East, 1: South, 2: West, 3: North
    static int[][] change = {
            {},             // Stuff 0
            {2, 1, 0, 3},   // Stuff 1
            {0, 3, 2, 1},   // Stuff 2
            {3, 2, 1, 0},   // Stuff 3
            {1, 0, 3, 2}    // Stuff 4
    };
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] wind;
    static boolean[][][] visit;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        wind = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        visit = new boolean[4][N][M];

        ArrayDeque<Node> q = new ArrayDeque<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (grid[r][c] == 9) {
                    for (int d = 0; d < 4; d++) {
                        q.offerLast(new Node(r, c, d));
                        visit[d][r][c] = true;
                        wind[r][c] = true;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.pollFirst();

            int id = grid[cur.r][cur.c];
            if (1 <= id && id <= 4) {
                cur.d = change[id][cur.d];
            }

            cur.r += dr[cur.d];
            cur.c += dc[cur.d];
            if (cur.r < 0 || cur.r >= N || cur.c < 0 || cur.c >= M) continue;
            if (visit[cur.d][cur.r][cur.c]) continue;
            q.offerLast(cur);
            visit[cur.d][cur.r][cur.c] = true;
            wind[cur.r][cur.c] = true;
        }

        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (wind[r][c]) answer++;
            }
        }
        System.out.println(answer);
    }
}

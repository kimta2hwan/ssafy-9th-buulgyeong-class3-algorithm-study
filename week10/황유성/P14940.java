import java.io.*;
import java.util.*;

public class P14940 {

    static int n, m, sr, sc;
    static int[][] grid;
    static int[][] dist;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        dist = new int[n][m];
        for (int r = 0; r < n; r++) {
            Arrays.fill(dist[r], -1);
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0) dist[r][c] = 0;
                else if (grid[r][c] == 2) {
                    sr = r;
                    sc = c;
                }
            }
        }
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(sr, sc));
        dist[sr][sc] = 0;
        int moveCnt = 0;
        while (!q.isEmpty()) {
            moveCnt++;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.pollFirst();

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if (dist[nr][nc] != -1) continue;
                    q.offerLast(new Node(nr, nc));
                    dist[nr][nc] = moveCnt;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                sb.append(dist[r][c]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

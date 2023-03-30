import java.io.*;
import java.util.*;

public class P17836 {

    static class Node {
        int sword;
        int r, c;

        Node(int sword, int r, int c) {
            this.sword = sword;
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, T;
    static int[][] grid;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1 ,0};
    static boolean[][][] visit;
    static ArrayDeque<Node> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        grid = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        visit = new boolean[2][N + 1][M + 1];

        q.offerLast(new Node(0, 1, 1));
        visit[0][1][1] = true;
        int time = 0;
        boolean rescue = false;
        loopW: while (time <= T && !q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.pollFirst();

                if (cur.r == N && cur.c == M) {
                    rescue = true;
                    break loopW;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (nr <= 0 || nr > N || nc <= 0 || nc > M)
                        continue;
                    if (grid[nr][nc] == 1 && cur.sword == 0)
                        continue;
                    if (grid[nr][nc] == 2)
                        cur.sword = 1;
                    if (visit[cur.sword][nr][nc])
                        continue;
                    q.offerLast(new Node(cur.sword, nr, nc));
                    visit[cur.sword][nr][nc] = true;
                }
            }
            time++;
        }
        System.out.println(rescue ? time : "Fail");
    }
}

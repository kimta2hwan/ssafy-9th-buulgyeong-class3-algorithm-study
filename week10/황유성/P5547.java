import java.util.*;
import java.io.*;

public class P5547 {

    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int W, H;
    static int[][] grid;
    static int[] edy = {-1, -1, 0, 1, 1, 0}; // 짝수 행
    static int[] edx = {-1, 0, 1, 0, -1, -1};
    static int[] ody = {-1, -1, 0, 1, 1, 0}; // 홀수 행
    static int[] odx = {0, 1, 1, 1, 0, -1};

    static ArrayDeque<Node> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        grid = new int[H + 2][W + 2];
        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        int answer = 0;
        q.offerLast(new Node(0, 0));
        while (!q.isEmpty()) {
            Node cur = q.pollFirst();

            int[] dy, dx;
            if ((cur.y & 1) == 1) {
                dy = ody;
                dx = odx;
            } else {
                dy = edy;
                dx = edx;
            }

            for (int d = 0; d < 6; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if (ny < 0 || ny >= H + 2 || nx < 0 || nx >= W + 2) continue;
                if (grid[ny][nx] == 0) {
                    q.offerLast(new Node(ny, nx));
                    grid[ny][nx] = -1;
                } else if (grid[ny][nx] == 1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}

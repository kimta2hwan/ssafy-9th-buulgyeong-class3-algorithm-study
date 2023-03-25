import java.io.*;
import java.util.*;

public class P1913 {

    static int N, target;
    static int[][] grid;
    static int[] step;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
    }

    static void solve() {
        step = new int[2 * N - 1];
        for (int i = 0 ; i < step.length; i++) {
            step[i] = (i + 2) / 2;
        }
        step[step.length - 1]--;

        grid = new int[N][N];
        int mid = N / 2;
        int y = mid, x = mid;
        int d = 0;
        int cnt = 1;
        grid[y][x] = cnt++;
        for (int s : step) {
            for (int i = 0; i < s; i++) {
                y += dy[d];
                x += dx[d];
                grid[y][x] = cnt++;
            }
            d = (d + 1) % 4;
        }

        StringBuilder answer = new StringBuilder();
        int ty = -1, tx = -1;
        for (y = 0; y < N; y++) {
            for (x = 0; x < N; x++) {
                answer.append(grid[y][x]).append(' ');
                if (grid[y][x] == target) {
                    ty = y + 1;
                    tx = x + 1;
                }
            }
            answer.append('\n');
        }
        answer.append(ty).append(' ').append(tx);
        System.out.print(answer);
    }
}

import java.io.*;
import java.util.*;

public class P2615 {

    static int[][] grid = new int[19][19];
    static int[] dr = {0, 1, 1, -1};
    static int[] dc = {1, 1, 0, 1};

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        for (int r = 0; r < 19; r++) {
            for (int c = 0; c < 19; c++) {
                if (grid[r][c] == 0) continue;
                for (int d = 0; d < 4; d++) {
                    if (win(r, c, d)) {
                        System.out.println(grid[r][c]);
                        System.out.printf("%d %d\n", r + 1, c + 1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean win(int r, int c, int d) {
        int color = grid[r][c];
        int pr = r - dr[d];
        int pc = c - dc[d];
        if (0 <= pr && pr < 19 && 0 <= pc && pc < 19 && grid[pr][pc] == color) return false;
        for (int i = 0; i < 4; i++) {
            r += dr[d];
            c += dc[d];
            if (r < 0 || r >= 19 || c < 0 || c >= 19 || grid[r][c] != color) return false;
        }
        r += dr[d];
        c += dc[d];
        return (r < 0 || r >= 19 || c < 0 || c >= 19 || grid[r][c] != color);
    }
}

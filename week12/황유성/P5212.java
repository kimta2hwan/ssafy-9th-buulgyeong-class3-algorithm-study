import java.io.*;
import java.util.*;

public class P5212 {

    static int R, C;
    static char[][] grid;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] submerge;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        grid = new char[R][];
        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine().toCharArray();
        }
    }

    static void solve() {
        submerge = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '.') continue;
                int seaCnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || grid[nr][nc] == '.') seaCnt++;
                }
                if (seaCnt >= 3) submerge[r][c] = true;
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (submerge[r][c]) grid[r][c] = '.';
            }
        }

        int minR = R;
        int maxR = -1;
        int minC = C;
        int maxC = -1;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 'X') {
                    if (r < minR) minR = r;
                    if (r > maxR) maxR = r;
                    if (c < minC) minC = c;
                    if (c > maxC) maxC = c;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = minR; r <= maxR; r++) {
            sb.append(String.copyValueOf(grid[r], minC, maxC - minC + 1)).append('\n');
        }
        System.out.print(sb);
    }
}

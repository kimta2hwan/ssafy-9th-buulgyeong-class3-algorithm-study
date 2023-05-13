import java.io.*;
import java.util.*;

public class P20543 {

    static int N, M;
    static long[][] grid, effect, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new long[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            long[] row = grid[i];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                row[j] = Long.parseLong(st.nextToken());
            }
        }

        final int HALF = M / 2;
        final int END = N - M + 1;
        answer = new long[N][N];
        effect = new long[N + 2][N + 2];
        for (int i = 1; i <= END; i++) {
            for (int j = 1; j <= END; j++) {
                effect[i][j] += effect[i - 1][j] + effect[i][j - 1] - effect[i - 1][j - 1];
                grid[i][j] += effect[i][j];
                if (grid[i][j] == 0) continue;
                grid[i][j] *= -1L;
                long numBomb = grid[i][j];
                answer[i - 1 + HALF][j - 1 + HALF] = numBomb;
                effect[i][j] += numBomb;
                effect[i + M][j] -= numBomb;
                effect[i][j + M] -= numBomb;
                effect[i + M][j + M] += numBomb;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long[] row = answer[i];
            for (int j = 0; j < N; j++) {
                sb.append(row[j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

import java.io.*;
import java.util.*;

public class P17829 {
    static int N;
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(cnn(0, 0, N));
    }

    static int cnn(int sr, int sc, int sz) {
        if (sz == 1) {
            return grid[sr][sc];
        } else {
            int half = sz / 2;
            int[] arr = new int[4];
            arr[0] = cnn(sr, sc, half);
            arr[1] = cnn(sr + half, sc, half);
            arr[2] = cnn(sr, sc + half, half);
            arr[3] = cnn(sr + half, sc + half, half);
            Arrays.sort(arr);
            return arr[2];
        }
    }
}
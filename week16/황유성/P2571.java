import java.io.*;
import java.util.*;

public class P2571 {

    static int N;
    static int[][] matrix = new int[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()) + 1;
            int sy = Integer.parseInt(st.nextToken()) + 1;

            for (int y = sy; y < sy + 10; y++) {
                for (int x = sx; x < sx + 10; x++) {
                    matrix[y][x] = 1;
                }
            }
        }

        for (int y = 1; y <= 100; y++) {
            for (int x = 1; x <= 100; x++) {
                matrix[y][x] += matrix[y][x - 1];
            }
        }

        for (int x = 1; x <= 100; x++) {
            for (int y = 1; y <= 100; y++) {
                matrix[y][x] += matrix[y - 1][x];
            }
        }

        int answer = 0;
        for (int y1 = 1; y1 <= 100; y1++) {
            for (int x1 = 1; x1 <= 100; x1++) {
                for (int y2 = y1; y2 <= 100; y2++) {
                    for (int x2 = x1; x2 <= 100; x2++) {
                        int area = (y2 - y1 + 1) * (x2 - x1 + 1);
                        int cnt = matrix[y2][x2] - matrix[y2][x1 - 1] - matrix[y1 - 1][x2] + matrix[y1 - 1][x1 - 1];
                        if (area == cnt && area > answer) answer = area;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
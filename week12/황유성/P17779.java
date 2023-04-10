import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17779 {

    static int N;
    static int[][] grid, psum, ppsum;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        psum = new int[N + 1][N + 1];
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                psum[y][x] = psum[y][x - 1] + grid[y - 1][x - 1];
            }
        }
        ppsum = new int[N + 1][N + 1];
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                ppsum[y][x] = ppsum[y - 1][x] + psum[y][x];
            }
        }

        final int TOTAL_SUM = ppsum[N][N];

        int answer = Integer.MAX_VALUE;
        for (int y = 2; y < N; y++) {
            for (int x = 1; x < N - 1; x++) {
                for (int d1 = 1; d1 <= y - 1; d1++) {
                    for (int d2 = 1; d2 <= N - y && d1 + d2 <= N - x; d2++) {
                        int diff = d1 - d2;

                        int num1 = ppsum[y - 1][x + d1];
                        for (int t = 0; t < d1; t++) {
                            num1 -= psum[y - 1 - t][x + d1] - psum[y - 1 - t][x + t];
                        }

                        int num2 = ppsum[y - diff][N] - ppsum[y - diff][x + d1];
                        for (int t = 0; t < d2; t++) {
                            num2 -= psum[y - diff - t][x + d1 + d2 - t] - psum[y - diff - t][x + d1];
                        }

                        int num3 = ppsum[N][N] - ppsum[N][x + d2 - 1] - ppsum[y - diff][N] + ppsum[y - diff][x + d2 - 1];
                        for (int t = 0; t < d1; t++) {
                            num3 -= psum[y - diff + 1 + t][x + d1 + d2 - 1 - t] - psum[y - diff + 1 + t][x + d2 - 1];
                        }

                        int num4 = ppsum[N][x + d2 - 1] - ppsum[y - 1][x + d2 - 1];
                        for (int t = 0; t < d2; t++) {
                            num4 -= psum[y + t][x + d2 - 1] - psum[y + t][x - 1 + t];
                        }

                        int num5 = TOTAL_SUM - (num1 + num2 + num3 + num4);

                        answer = Math.min(answer, calc(num1, num2, num3, num4, num5));
                    }
                }
            }
        }
        System.out.println(answer);
    }
    static int calc(int... nums) {
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < minNum) minNum = num;
            if (num > maxNum) maxNum = num;
        }
        return maxNum - minNum;
    }
}
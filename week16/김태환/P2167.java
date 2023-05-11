class P2167 {
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        int[][] prefixSum = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int n = read();
                prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1] + n;
            }
        }

        StringBuilder sb = new StringBuilder();
        int K = read();

        while (K-- > 0) {
            int i = read();
            int j = read();
            int x = read();
            int y = read();

            sb.append(prefixSum[x][y] - prefixSum[i - 1][y] - prefixSum[x][j - 1] + prefixSum[i - 1][j - 1])
                    .append('\n');
        }

        System.out.print(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;

        if (isNegative) {
            n = System.in.read() & 15;
        }

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return isNegative ? ~n + 1 : n;
    }
}

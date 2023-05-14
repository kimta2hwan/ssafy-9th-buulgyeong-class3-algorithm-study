class P11441 {
    public static void main(String[] args) throws Exception {
        int N = read();
        int[] prefixSum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + read();
        }

        StringBuilder sb = new StringBuilder();
        int M = read();

        while (M-- > 0) {
            int i = read();
            int j = read();

            sb.append(prefixSum[j] - prefixSum[i - 1]).append('\n');
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

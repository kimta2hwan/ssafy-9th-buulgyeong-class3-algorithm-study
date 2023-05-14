import java.util.Arrays;

class P17390 {
    public static void main(String[] args) throws Exception {
        int N = read();
        int Q = read();
        int[] A = new int[N];
        int[] prefixSum = new int[N + 1];

        for (int i = 0; i < N; i++) {
            A[i] = read();
        }

        Arrays.sort(A);

        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i - 1];
        }

        StringBuilder sb = new StringBuilder();

        while (Q-- > 0) {
            int L = read();
            int R = read();

            sb.append(prefixSum[R] - prefixSum[L - 1]).append('\n');
        }

        System.out.print(sb);
    }
    
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}

class P18511 {

    private static int[] arr;
    private static int N, K, answer;

    public static void main(String[] args) throws Exception {
        N = read();
        K = read();
        arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = read();
        }

        dfs(0);
        System.out.print(answer);
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

    private static void dfs(int now) {
        if (now > N) {
            return;
        }

        if (answer < now) {
            answer = now;
        }

        for (int i = 0; i < K; i++) {
            dfs(now * 10 + arr[i]);
        }
    }
}

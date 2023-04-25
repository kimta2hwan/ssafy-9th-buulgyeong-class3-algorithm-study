class P15649 {

    private static StringBuilder sb;
    private static int[] arr;
    private static int N, M;

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();
        arr = new int[M];

        sb = new StringBuilder();
        perm(0, 0);

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

    private static void perm(int depth, int mask) {
        if (depth == M) {
            for (int i : arr) {
                if ((mask & (1 << i)) == 0) {
                    continue;
                }

                sb.append(i).append(' ');
            }

            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if ((mask & (1 << i)) != 0) {
                continue;
            }

            arr[depth] = i;
            perm(depth + 1, mask | (1 << i));
        }
    }
}

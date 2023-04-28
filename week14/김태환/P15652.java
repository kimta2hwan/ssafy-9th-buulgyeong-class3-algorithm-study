class P15652 {

    private static StringBuilder sb;
    private static int[] arr;
    private static int N, M;

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        sb = new StringBuilder();
        arr = new int[M];

        perm(0, 1);
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

    private static void perm(int depth, int start) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }

            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            perm(depth + 1, i);
        }
    }
}

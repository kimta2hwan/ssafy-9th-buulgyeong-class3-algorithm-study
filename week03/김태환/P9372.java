class P9372 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int T = read();
        int N, M;

        while (T-- > 0) {
            N = read();
            M = read();

            while (M-- > 0) {
                read();
                read();
            }

            sb.append(N - 1).append('\n');
        }

        System.out.println(sb);
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

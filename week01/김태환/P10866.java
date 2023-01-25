class P10866 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = read();
        int[] deque = new int[N * 2 + 1];
        int head = N, tail = N - 1;

        while (N-- > 0) {
            switch (read()) {
                case 539563644: deque[--head] = read(); break;
                case 53952141: deque[++tail] = read(); break;
                case 151563644: sb.append(head > tail ? -1 : deque[head++]).append('\n'); break;
                case 15152141: sb.append(head > tail ? -1 : deque[tail--]).append('\n'); break;
                case 4005: sb.append(tail - head + 1).append('\n'); break;
                case 63049: sb.append(head > tail ? 1 : 0).append('\n'); break;
                case 63644: sb.append(head > tail ? -1 : deque[head]).append('\n'); break;
                case 2141: sb.append(head > tail ? -1 : deque[tail]).append('\n'); break;
            }
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
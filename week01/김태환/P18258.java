class P18258 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = read(), head = 0, rear = -1;
        int[] queue = new int[N];

        while (N-- > 0) {
            switch (read()) {
                case 538: queue[++rear] = read(); break;
                case 150: sb.append(head > rear ? -1 : queue[head++]).append('\n'); break;
                case 4005: sb.append(rear - head + 1).append('\n'); break;
                case 63049: sb.append(head > rear ? 1 : 0).append('\n'); break;
                case 63644: sb.append(head > rear ? -1 : queue[head]).append('\n'); break;
                case 2141: sb.append(head > rear ? -1 : queue[rear]).append('\n');
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
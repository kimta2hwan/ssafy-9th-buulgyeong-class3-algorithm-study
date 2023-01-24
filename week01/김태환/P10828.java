class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = read();

        int[] stack = new int[N];
        int top = -1;

        while (N-- > 0) {
            switch(read()) {
                case 538: stack[++top] = read(); break;
                case 150: sb.append(top == -1 ? -1 : stack[top--]).append('\n'); break;
                case 4005: sb.append(top + 1).append('\n'); break;
                case 63049: sb.append(top == -1 ? 1 : 0).append('\n'); break;
                default: sb.append(top == -1 ? -1 : stack[top]).append('\n');
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

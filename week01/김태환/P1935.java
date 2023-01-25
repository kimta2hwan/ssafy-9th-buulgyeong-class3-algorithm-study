class P1935 {
    public static void main(String[] args) throws Exception {
        int top = -1, N = readInt();
        StringBuilder input = readString();
        double[] stack = new double[100];
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = readInt();
        }

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            
            if (cur > 64) {
                stack[++top] = arr[cur - 'A'];

            } else {
                switch (cur) {
                    case '+': stack[top - 1] = stack[top - 1] + stack[top]; break;
                    case '-': stack[top - 1] = stack[top - 1] - stack[top]; break;
                    case '*': stack[top - 1] = stack[top - 1] * stack[top]; break;
                    case '/': stack[top - 1] = stack[top - 1] / stack[top]; break;
                }

                top--;
            }
        }

        System.out.printf("%.2f", stack[top]);
    }

    private static int readInt() throws Exception {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }

    private static StringBuilder readString() throws Exception {
        StringBuilder sb = new StringBuilder().append((char)System.in.read());
        int c;

        while ((c = System.in.read()) > 32) {
            sb.append((char)c);
        }

        if (c == 13) {
            System.in.read();
        }

        return sb;
    }
}
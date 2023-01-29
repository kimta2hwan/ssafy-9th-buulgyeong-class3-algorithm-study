class P1863 {
    public static void main(String[] args) throws Exception {
        int N = read();
        int[] arr = new int[50002];

        for (int i = 0; i < N; i++) {
            read();
            arr[i] = read();
        }

        int[] stack = new int[50002];
        int top = -1;
        int answer = 0;

        for (int i = 0; i <= N; i++) {
            while (top > -1 && stack[top] > arr[i]) {
                answer++;
                top--;
            }

            if (top > -1 && stack[top] == arr[i]) {
                continue;
            }

            stack[++top] = arr[i];
        }

        System.out.println(answer);
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

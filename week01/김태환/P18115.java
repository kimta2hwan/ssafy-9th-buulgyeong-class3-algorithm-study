class P18115 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = read();
        int[] deque = new int [N * 2 + 1];
        int[] arr = new int[N];
        int index = 1, head = N, tail = N - 1;

        for (int i = 0; i < N; i++) {
            arr[i] = read();
        }

        for (int i = N - 1; i > -1; i--) {
            switch (arr[i]) {
                case 1: deque[++tail] = index++; break;
                case 2:
                    int temp = deque[tail--];
                    deque[++tail] = index++;
                    deque[++tail] = temp;
                    break;

                case 3: deque[--head] = index++; break;
            }
        }

        for (int i = tail; i >= head; i--) {
            sb.append(deque[i]).append(' ');
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
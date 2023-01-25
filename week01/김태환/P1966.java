class P1966 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int T = read();

        while (T-- > 0) {
            int N = read(), M = read();
            int answer = 0, max = 9, target = 0;
            int[] queue = new int[N];
            int[] count = new int[10];

            for (int i = 0; i < N; i++) {
                queue[i] = read();
            }

            for (int i = 0; i < N; i++) {
                count[queue[i]]++;
            }

            while (true) {
                while (count[max] == 0) {
                    max--;
                }

                if (queue[target] == max) {
                    count[max]--;
                    answer++;

                    if (target == M) {
                        break;
                    }
                }

                target = (target + 1) % N;
            }

            sb.append(answer).append('\n');
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
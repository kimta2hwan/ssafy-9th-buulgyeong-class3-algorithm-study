class P22866 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = read();
        int[][] answer = new int[N + 1][2];
        int[] building = new int[N + 1];
        int[][] stack = new int[N][2];
        int top = -1;

        for (int i = 1; i <= N; i++) {
            building[i] = read();

            while (top > -1 && stack[top][0] <= building[i]) {
                top--;
            }

            answer[i][0] += top + 1;

            if (top > -1) {
                answer[i][1] = stack[top][1];
            }

            stack[++top][0] = building[i];
            stack[top][1] = i;
        }

        top = -1;

        for (int i = N; i >= 1; i--) {
            while (top > -1 && stack[top][0] <= building[i]) {
                top--;
            }

            answer[i][0] += top + 1;

            if (top > -1 && (answer[i][1] == 0 || stack[top][1] - i < i - answer[i][1])) {
                answer[i][1] = stack[top][1];
            }

            stack[++top][0] = building[i];
            stack[top][1] = i;
        }

        for (int i = 1; i <= N; i++) {
            sb.append(answer[i][0]);

            if (answer[i][0] > 0) {
                sb.append(' ').append(answer[i][1]);
            }

            sb.append('\n');
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

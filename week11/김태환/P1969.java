class P1969 {
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        byte[][] buffer = new byte[N][M + 2];
        int[][] count = new int[M][4];

        for (int i = 0; i < N; i++) {
            System.in.read(buffer[i]);

            for (int j = 0; j < M; j++) {
                switch (buffer[i][j]) {
                    case 'A': count[j][0]++; break;
                    case 'C': count[j][1]++; break;
                    case 'G': count[j][2]++; break;
                    case 'T': count[j][3]++; break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int answer = 0;

        for (int i = 0; i < M; i++) {
            int max = count[i][0];
            char c = 'A';

            if (count[i][1] > max) {
                max = count[i][1];
                c = 'C';
            }

            if (count[i][2] > max) {
                max = count[i][2];
                c = 'G';
            }

            if (count[i][3] > max) {
                max = count[i][3];
                c = 'T';
            }

            sb.append(c);

            for (int j = 0; j < N; j++) {
                if (buffer[j][i] == c) {
                    continue;
                }

                answer++;
            }
        }

        sb.append('\n').append(answer);
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
}

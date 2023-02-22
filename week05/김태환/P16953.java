class P16953 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int A = read();
        int B = read();
        int answer = 1;

        while (true) {
            if (B == A) {
                sb.append(answer);
                break;
            }

            if (B < A) {
                sb.append(-1);
                break;
            }

            if (B % 2 == 0) {
                B /= 2;
                answer++;

            } else if (B % 10 == 1) {
                B /= 10;
                answer++;

            } else {
                sb.append(-1);
                break;
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

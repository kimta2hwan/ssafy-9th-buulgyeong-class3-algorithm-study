class P5397 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        char[] left = new char[1000000];
        char[] right = new char[1000000];
        int leftTop, rightTop, c;
        int L = readInt();

        while (L-- > 0) {
            leftTop = -1;
            rightTop = -1;

            while ((c = System.in.read()) > 32) {
                switch (c) {
                    case 45:
                        if (leftTop > -1) {
                            leftTop--;
                        }

                        break;

                    case 60:
                        if (leftTop > -1) {
                            right[++rightTop] = left[leftTop--];
                        }

                        break;

                    case 62:
                        if (rightTop > -1) {
                            left[++leftTop] = right[rightTop--];
                        }

                        break;

                    default: left[++leftTop] = (char)c;
                }
            }

            for (int i = 0; i <= leftTop; i++) {
                sb.append(left[i]);
            }

            for (int i = rightTop; i > -1; i--) {
                sb.append(right[i]);
            }

            sb.append('\n');
        }

        System.out.println(sb);
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
}
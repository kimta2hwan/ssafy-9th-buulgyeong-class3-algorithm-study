class Main2 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int T = read();

        while (T-- > 0) {
            int c, count = 0;
            boolean flag = true;

            while ((c = System.in.read()) > 32) {
                if (c == 40) {
                    count++;

                } else {
                    if (count == 0) {
                        flag = false;

                    }

                    count--;
                }
            }

            if (c == 13) {
                System.in.read();
            }

            if (count != 0) {
                flag = false;
            }

            sb.append(flag ? "YES\n" : "NO\n");
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

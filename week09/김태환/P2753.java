class P2753 {
    public static void main(String[] args) throws Exception {
        int year = read();

        if ((year % 100 > 0 && year % 4 == 0) || year % 400 == 0) {
            System.out.println(1);
            return;
        }

        System.out.println(0);
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

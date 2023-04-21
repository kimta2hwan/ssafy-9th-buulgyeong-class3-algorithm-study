class P1789 {
    public static void main(String[] args) throws Exception {
        long S = read();
        long sum = 0;
        int count = 0;

        for (int i = 1; sum <= S; i++) {
            sum += i;
            count++;
        }

        System.out.print(count - 1);
    }

    private static long read() throws Exception {
        long n = System.in.read() & 15;
        int c;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}

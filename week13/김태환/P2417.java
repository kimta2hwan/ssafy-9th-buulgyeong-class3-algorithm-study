class P2417 {

    public static void main(String[] args) throws Exception {
        System.out.print(binarySearch(read()));
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

    private static long binarySearch(long n) {
        long start = 0;
        long end = n;
        long min = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long pow = (long)Math.pow(mid, 2);

            if (pow >= n) {
                min = mid;
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }

        return min;
    }
}

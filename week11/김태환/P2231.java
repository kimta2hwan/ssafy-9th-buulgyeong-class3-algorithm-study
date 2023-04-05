class P2231 {
	public static void main(String[] args) throws Exception {
        int N = read();

        for (int i = 1; i < N; i++) {
            int sum = i;
            int n = i;

            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }

            if (sum == N) {
                System.out.println(i);
                return;
            }
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

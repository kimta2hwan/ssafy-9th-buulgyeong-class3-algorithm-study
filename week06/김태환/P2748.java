class P2748 {
	public static void main(String[] args) throws Exception {
		int n = read();
		
		long[] fibo = new long[n + 1];
		fibo[0] = 0;
		fibo[1] = 1;
		
		for (byte i = 2; i <= n; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
		
		System.out.println(fibo[n]);
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

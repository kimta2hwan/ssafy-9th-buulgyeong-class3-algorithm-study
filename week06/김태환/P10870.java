class P10870 {
	public static void main(String[] args) throws Exception {
		System.out.println(fibo(read()));
	}
	
	private static int fibo(int n) {
		if (n == 0) {
			return 0;
		}
		
		if (n == 1 || n == 2) {
			return 1;
		}
		
		return fibo(n - 1) + fibo(n - 2);
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

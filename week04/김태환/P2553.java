class P2553 {
	public static void main(String[] args) throws Exception {
		int N = read();
		long fact = 1;
		
		for (int i = 2; i <= N; i++) {
			fact *= i;
			fact %= 1000000000;
			
			while (fact % 10 == 0) {
				fact /= 10;
			}
		}
		
		System.out.println(fact % 10);
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

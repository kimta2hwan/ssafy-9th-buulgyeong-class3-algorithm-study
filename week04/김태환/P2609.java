class P2609 {
	public static void main(String[] args) throws Exception {
		int a = read();
		int b = read();
		int gcd = gcd(a, b);
		
		System.out.println(gcd);
		System.out.println(a * b / gcd);
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
	
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}

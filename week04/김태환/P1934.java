class P1934 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int T = read();
		
		while (T-- > 0) {
			sb.append(lcm(read(), read())).append('\n');
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
	
	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}

class P5347 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int n = read();
		
		while (n-- > 0) {
			long a = read();
			long b = read();
			
			sb.append(a * b / gcd(a, b)).append('\n');
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
	
	private static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}

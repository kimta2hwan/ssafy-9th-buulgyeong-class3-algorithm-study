class P2436 {
	public static void main(String[] args) throws Exception {
		int gcd = read();
		int lcm = read();
		int x = lcm / gcd;
		int rx = (int) Math.sqrt(x);
		
		int a = 0;
		int b = 0;
		
		for (int i = rx; i > 0; i--) {
			if (x % i != 0) {
				continue;
			}
			
			a = i;
			b = x / i;
			
			if (gcd(a, b) == 1) {
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(a * gcd).append(' ').append(b * gcd);
		
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
	
	private static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}

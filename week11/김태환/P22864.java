class P22864 {
	public static void main(String[] args) throws Exception {
		int A = read();
		int B = read();
		int C = read();
		int M = read();
		
		int t = 0;
		int a = 0;
		int b = 0;
		
		while (t++ < 24) {
			if (a + A > M) {
				a -= C;
				
				if (a < 0) {
					a = 0;
				}
				
			} else {
				a += A;
				b += B;
			}
		}
		
		System.out.println(b);
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

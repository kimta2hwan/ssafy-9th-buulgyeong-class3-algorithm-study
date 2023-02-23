class P17521 {
	public static void main(String[] args) throws Exception {
		int n = read();
		long W = read();
		int[] s = new int[n];
		
		for (int i = 0; i < n; i++) {
			s[i] = read();
		}
		
		long coin = 0;
		
		for (int i = 1; i < n; i++) {
			if (s[i] > s[i - 1]) {
				coin = W / s[i - 1];
				W = coin * s[i] + W % s[i - 1];
				
			}
		}
		
		System.out.println(W);
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

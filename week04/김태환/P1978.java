class P1978 {
	public static void main(String[] args) throws Exception {
		boolean[] prime = new boolean[1001];
		prime[0] = prime[1] = true;
		
		for (int i = 2; i * i <= 1000; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= 1000; j += i) {
					prime[j] = true;
				}
			}
		}
		
		int N = read();
		int count = 0;
		
		while (N-- > 0) {
			if (!prime[read()]) {
				count++;
			}
		}
		
		System.out.println(count);
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

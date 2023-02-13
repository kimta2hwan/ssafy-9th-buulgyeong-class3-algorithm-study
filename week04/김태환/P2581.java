class P2581 {
	public static void main(String[] args) throws Exception {
		int M = read();
		int N = read();
		
		boolean[] prime = new boolean[N + 1];
		prime[0] = prime[1] = true;
		
		for (int i = 2; i * i <= N; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= N; j += i) {
					prime[j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int min = 0;
		int sum = 0;
		
		for (int i = M; i <= N; i++) {
			if (!prime[i]) {
				sum += i;
				
				if (min == 0) {
					min = i;
				}
			}
		}
		
		if (sum == 0) {
			System.out.println(-1);
			return;
		}
		
		sb.append(sum).append('\n').append(min);
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
}

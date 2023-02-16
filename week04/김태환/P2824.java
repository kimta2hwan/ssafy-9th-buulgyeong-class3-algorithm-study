class P2824 {
	
	private static final int MAX = 1000000000;
	
	public static void main(String[] args) throws Exception {
		int N = read();
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = read();
		}
		
		int M = read();
		int[] B = new int[M];
		
		for (int i = 0; i < M; i++) {
			B[i] = read();
		}
		
		long answer = 1;
		boolean flag = false;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int gcd = gcd(A[i], B[j]);
				answer *= gcd;
				
				if (answer >= MAX) {
					flag = true;
				}
				
				answer %= MAX;
				A[i] /= gcd;
				B[j] /= gcd;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		String str = String.valueOf(answer);
		
		if (flag) {
			if (str.length() < 9) {
				while (sb.length() + str.length() < 9) {
					sb.append('0');
				}
			}
		}
		
		sb.append(answer);
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

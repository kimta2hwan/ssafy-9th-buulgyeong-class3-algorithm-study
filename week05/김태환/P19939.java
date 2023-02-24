class P19939 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int K = read();
		
		for (int i = 1; i <= K; i++) {
			N -= i;
			
			if (N < 0) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(N % K > 0 ? K : K - 1);
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

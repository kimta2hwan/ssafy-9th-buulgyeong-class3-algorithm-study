class P2798 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int M = read();
		
		int[] card = new int[N];
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			card[i] = read();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = card[i] + card[j] + card[k];
					
					if (sum == M) {
						System.out.println(M);
						return;
						
					}
					
					if (sum < M && sum > max) {
						max = sum;
					}
				}
			}
		}
		
		System.out.print(max);
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

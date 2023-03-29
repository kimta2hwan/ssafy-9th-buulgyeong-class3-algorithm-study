class P2559 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int K = read();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = read();
		}
		
		int sum = 0;
		
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}
		
		int max = sum;
		
		for (int i = K, j = 0; i < N; i++, j++) {
			if ((sum = sum - arr[j] + arr[i]) > max) {
				max = sum;
			}
		}
		
		System.out.print(max);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean isNegative = n == 13;
		
		if (isNegative) {
			n = System.in.read() & 15;
		}
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}

        if (c == 13) {
            System.in.read();
        }
		
		return isNegative ? ~n + 1 : n;
	}
}

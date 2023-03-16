class P10025 {
	public static void main(String[] args) throws Exception {
		int[] arr = new int[1000001];
		int N = read();
		int K = read() * 2 + 1;
		
		while (N-- > 0) {
			int g = read();
			arr[read()] = g;
		}
		
		int sum = 0;
		
		for (int i = 0; i < K && i <= 1000000; i++) {
			sum += arr[i];
		}
		
		int max = sum;
		
		for (int i = K, j = 0; i <= 1000000; i++, j++) {
			sum += arr[i];
			sum -= arr[j];
			
			if (sum > max) {
				max = sum;
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

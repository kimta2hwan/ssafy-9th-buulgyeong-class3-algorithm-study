class P9613 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int t = read();
		
		while (t-- > 0) {
			int n = read();
			int[] arr = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = read();
			}
			
			long sum = 0;
			
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					sum += gcd(arr[i], arr[j]);
				}
			}
			
			sb.append(sum).append('\n');
		}
		
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

class P21921 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int X = read();
		int[] arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + read();
		}
		
		int max = 0;
		int count = 1;
		
		for (int i = X; i <= N; i++) {
			int total = arr[i] - arr[i - X];
			
			if (total > max) {
				max = total;
				count = 1;
				
			} else if (total == max) {
				count++;
			}
		}
		
		if (max == 0) {
			System.out.println("SAD");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(max).append('\n').append(count);
		
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

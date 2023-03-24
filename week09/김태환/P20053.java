class P20053 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int T = read();
		
		while (T-- > 0) {
			boolean[] arr = new boolean[2000001];
			int N = read();
			
			while (N-- > 0) {
				arr[read() + 1000000] = true;
			}
			
			for (int i = 0; i <= 2000000; i++) {
				if (arr[i]) {
					sb.append(i - 1000000).append(' ');
					break;
				}
			}
			
			for (int i = 2000000; i >= 0; i--) {
				if (arr[i]) {
					sb.append(i - 1000000).append('\n');
					break;
				}
			}
		}
		
		System.out.println(sb);
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

class P21313 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int N = read();
		
		if (N % 2 == 0) {
			for (int i = 0; i < N / 2; i++) {
				sb.append("1 2 ");
			}
			
		} else {
			for (int i = 0; i < N / 2; i++) {
				sb.append("1 2 ");
			}
			
			sb.append(3);
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
}

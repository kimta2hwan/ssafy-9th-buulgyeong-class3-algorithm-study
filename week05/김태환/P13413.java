class P13413 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int T = read();
		
		while (T-- > 0) {
			int N = read();
			
			byte[] init = new byte[N + 1];
			System.in.read(init);
			
			byte[] target = new byte[N + 1];
			System.in.read(target);
			
			int countW = 0;
			int countB = 0;
			
			for (int i = 0; i < N; i++) {
				if (init[i] != target[i]) {
					if (init[i] == 'W') {
						countW++;
						
					} else {
						countB++;
					}
				}
			}
			
			sb.append(countW > countB ? countW : countB).append('\n');
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

class P21918 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int M = read();
		
		int[] bulb = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			bulb[i] = read();
		}
		
		while (M-- > 0) {
			int a = read();
			int b = read();
			int c = read();
			
			switch (a) {
				case 1:
					bulb[b] = c;
					
					break;

				case 2:
					for (int i = b; i <= c; i++) {
						bulb[i] ^= 1;
					}
					
					break;
				
				case 3:
					for (int i = b; i <= c; i++) {
						bulb[i] = 0;
					}
					
					break;

				default:
					for (int i = b; i <= c; i++) {
						bulb[i] = 1;
					}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			sb.append(bulb[i]).append(' ');
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

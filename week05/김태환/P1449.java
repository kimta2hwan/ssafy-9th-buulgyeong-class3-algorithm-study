class P1449 {
	public static void main(String[] args) throws Exception {
		int[] pipe = new int[1001];
		int N = read();
		int L = read();
		
		while (N-- > 0) {
			pipe[read()]++;
		}
		
		int tape = 0;
		
		for (int i = 1; i <= 1000; i++) {
			if (pipe[i] != 0) {
				i += L - 1;
				tape++;
			}
		}
		
		System.out.println(tape);
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

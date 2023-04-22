class P10815 {
	
	public static void main(String[] args) throws Exception {
		boolean[] cards = new boolean[20000001];
		int N = read();
		
		while (N-- > 0) {
			cards[read() + 10000000] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		int M = read();
		
		while (M-- > 0) {
			sb.append(cards[read() + 10000000] ? 1 : 0).append(' ');
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

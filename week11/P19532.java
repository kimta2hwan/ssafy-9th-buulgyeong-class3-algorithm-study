class P19532 {
	public static void main(String[] args) throws Exception {
		int a = read();
		int b = read();
		int c = read();
		int d = read();
		int e = read();
		int f = read();
		
		StringBuilder sb = new StringBuilder();
		sb.append((e * c - b * f) / (a * e - b * d)).append(' ').append((c * d - a * f) / (b * d - a * e));
		
		System.out.print(sb);
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

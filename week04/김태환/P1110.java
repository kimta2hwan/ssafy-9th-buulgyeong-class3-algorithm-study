class P1110 {
	public static void main(String[] args) throws Exception {
		int N = read();
		
		int n = N;
		int count = 0;
		
		do {
			n = (n % 10) * 10 + ((n / 10) + n % 10) % 10;
			count++;
			
		} while (n != N);
		
		System.out.println(count);
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

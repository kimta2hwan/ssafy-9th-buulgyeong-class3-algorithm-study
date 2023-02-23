class P1817 {
	public static void main(String[] args) throws Exception {
		int N = read();
		
		if (N == 0) {
			System.out.println(0);
			return;
		}
		
		int M = read();
		int sum = 0;
		int count = 1;
		
		while (N-- > 0) {
			int book = read();
			
			if (sum + book > M) {
				sum = book;
				count++;
				
			} else {
				sum += book;
			}
		}
		
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

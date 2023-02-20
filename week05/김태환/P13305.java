class P13305 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int[] len = new int [N - 1];
		
		for (int i = 0; i < N - 1; i++) {
			len[i] = read();
		}
		
		long minPrice = Integer.MAX_VALUE;
		long sum = 0;
		
		for (int i = 0; i < N - 1; i++) {
			int price = read();
			
			if (price < minPrice) {
				minPrice = price;
			}
			
			sum += minPrice * len[i];
		}
		
		System.out.println(sum);
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

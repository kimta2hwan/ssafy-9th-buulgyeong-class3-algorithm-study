class P20115 {
	public static void main(String[] args) throws Exception {
		int N = read();
		double sum = 0;
		double max = 0;
		
		while (N-- > 0) {
			double drink = read() / 2D;
			sum += drink;
			
			if (drink > max) {
				max = drink;
			}
		}
		
		System.out.println(sum + max);
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

class P14916 {
	public static void main(String[] args) throws Exception {
		int n = read();
		int count = 0;
		
		while (n > 0) {
			if (n % 5 == 0) {
				count += n / 5;
				break;
			}
			
			n -= 2;
			count++;
		}
		
		System.out.println(n < 0 ? -1 : count);
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

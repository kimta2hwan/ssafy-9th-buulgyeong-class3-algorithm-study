class P16162 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int A = read();
		int D = read();
		int count = 0;
		
		while (N-- > 0) {
			int sound = read();
			
			if (sound == A) {
				A += D;
				count++;
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

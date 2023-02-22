class P20365 {
	
	private static final byte B = 66;
	
	public static void main(String[] args) throws Exception {
		int N = read();
		byte[] buffer = new byte[N + 2];
		
		System.in.read(buffer);
		
		int bCount = 0;
		int rCount = 0;
		byte color = 0;
		
		for (int i = 0; i < N; i++) {
			if (buffer[i] != color) {
				color = buffer[i];
				
				if (color == B) {
					bCount++;
					
				} else {
					rCount++;
				}
			}
		}
		
		System.out.println(bCount > rCount ? rCount + 1 : bCount + 1);
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

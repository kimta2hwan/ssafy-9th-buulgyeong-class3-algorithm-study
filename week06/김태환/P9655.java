class P9655 {
	public static void main(String[] args) throws Exception {
		System.out.println(read() % 2 == 0 ? "CY" : "SK");
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

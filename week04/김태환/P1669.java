class P1669 {
	public static void main(String[] args) throws Exception {
		int X = read();
		int Y = read();
		
		int height = Y - X;
		
		if (height < 1) {
			System.out.println(0);
			return;
		}
		
		long count = 0;
		
		while (count * count < height) {
			count++;
		}
		
		if (count * count != height) {
			count--;
		}
		
		long sum = count * 2 - 1;
		height -= count * count;
		
		while (height > 0) {
			height -= min(count, height);
			sum++;
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
	
	private static long min(long a, long b) {
		return a < b ? a : b;
	}
}

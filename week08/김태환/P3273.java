class P3273 {
	public static void main(String[] args) throws Exception {
		boolean[] a = new boolean[1000001];
		int n = read();
		
		while (n-- > 0) {
			a[read()] = true;
		}
		
		int x = read();
		int left = -1;
		int right = 1000001;
		int count = 0;
		
		while (!a[++left]) {}
		while (!a[--right]) {}
		
		while (left < right) {
			int sum = left + right;
			
			if (sum == x) {
				while (!a[++left]) {}
				while (!a[--right]) {}
				
				count++;
				
			} else if (sum > x) {
				while (!a[--right]) {}
				
			} else {
				while (!a[++left]) {}
			}
		}
		
		System.out.print(count);
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

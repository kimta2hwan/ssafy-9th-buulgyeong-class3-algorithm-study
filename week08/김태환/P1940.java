class P1940 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int M = read();
		
		boolean[] stuff = new boolean[100001];
		
		while (N-- > 0) {
			stuff[read()] = true;
		}
		
		int left = -1;
		int right = 100001;
		int count = 0;
		
		while (!stuff[++left]) {}
		while (!stuff[--right]) {}
		
		while (left < right) {
			int sum = left + right;
			
			if (sum == M) {
				while (!stuff[++left]) {}
				while (!stuff[--right]) {}
				count++;
				
			} else if (sum > M) {
				while (!stuff[--right]) {}
				
			} else {
				while (!stuff[++left]) {}
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

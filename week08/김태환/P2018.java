class P2018 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int sum = 1;
		int count = 0;
		
		int leftPointer = 1;
		int rightPointer = 1;
		
		while (rightPointer <= N) {
			if (sum == N) {
				count++;
			}
			
			sum += ++rightPointer;
			
			while (sum > N) {
				sum -= leftPointer++;
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

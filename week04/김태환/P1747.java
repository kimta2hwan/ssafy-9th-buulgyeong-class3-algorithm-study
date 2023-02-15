class P1747 {
	public static void main(String[] args) throws Exception {
		int N = read();
		
		while (!isPalindrome(N) || !isPrime(N)) {
			N++;
		}
		
		System.out.println(N);
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
	
	private static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isPalindrome(int n) {
		int right = n;
		int left = 0;
		
		while (right > 0) {
			left = ((left << 3) + (left << 1)) + right % 10;
			right /= 10;
		}
		
		return n == left;
	}
}

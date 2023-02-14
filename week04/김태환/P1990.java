class P1990 {
	public static void main(String[] args) throws Exception {
		int a = read();
		int b = read();
		
		boolean[] isNotPrime = new boolean[b + 1];
		isNotPrime[0] = isNotPrime[1] = true;
		
		for (int i = 2; i * i < b + 1; i++) {
			 if (isNotPrime[i]) {
				 continue;
			 }
			 
			 for (int j = i * i; j < b + 1; j += i) {
				 isNotPrime[j] = true;
			 }
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = a; i <= b; i++) {
			if (isNotPrime[i] || isNotPalindrome(i)) {
				continue;
			}
			
			sb.append(i).append('\n');
		}
		
		sb.append(-1);
		System.out.println(sb);
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
	
	private static boolean isNotPalindrome(int n) {
		String str = String.valueOf(n);
		int len = str.length();
		
		for (int i = 0, j = len - 1; i < len; i++, j--) {
			if (str.charAt(i) == str.charAt(j)) {
				continue;
			}
			
			return true;
		}
		
		return false;
	}
}

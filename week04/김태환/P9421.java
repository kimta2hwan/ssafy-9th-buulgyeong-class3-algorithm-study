class P9421 {
	
	static int[] check = new int[1000001];
	
	public static void main(String[] args) throws Exception {
		boolean[] isNotPrime = new boolean[1000001];
		isNotPrime[0] = isNotPrime[1] = true;
		
		for (int i = 2; i * i < 1000001; i++) {
			if (isNotPrime[i]) {
				continue;
			}
			
			for (int j = i * i; j < 1000001; j += i) {
				isNotPrime[j] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int n = read();
		check[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			if (isNotPrime[i] || isCheck(i) != 1) {
				continue;
			}
			
			sb.append(i).append('\n');
		}
		
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
	
	private static int isCheck(int n) {
		if (check[n] != 0) {
			return check[n];
		}
		
		int temp = n;
		check[n] = 2;
		int sum = 0;
		
		while (n > 0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		
		return check[temp] = isCheck(sum);
	}
}

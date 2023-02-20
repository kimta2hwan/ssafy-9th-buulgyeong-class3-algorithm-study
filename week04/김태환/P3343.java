class P3343 {
	
	static long N, A, B, C, D;
	
	public static void main(String[] args) throws Exception {
		N = read();
		A = read();
		B = read();
		C = read();
		D = read();
		
		if (A * D < B * C) {
			System.out.println(solve(A, B, C, D));
			
		} else {
			System.out.println(solve(C, D, A, B));
		}
	}
  
	private static long read() throws Exception {
		long n = System.in.read() & 15;
		int c;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}

        if (c == 13) {
            System.in.read();
        }
	  
		return n;
	}
	
	static long solve(long aAmount, long aPrice, long bAmount, long bPrice) {
		long result = Long.MAX_VALUE;
		long lcm = lcm(aAmount, bAmount);
		long aCount = 0;
		
		while (aAmount * aCount < lcm) {
			long remainder = N - (aAmount * aCount);
			
			if (remainder < 0) {
				result = Math.min(result, (aPrice * aCount));
				break;
			}
      
			long bCount = remainder / bAmount;
			
			if (remainder % bAmount != 0) {
				bCount += 1;
			}

			result = Math.min(result, (aPrice * aCount) + (bPrice * bCount));
			aCount += 1;
		}
		
		return result;
	}
	
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
}
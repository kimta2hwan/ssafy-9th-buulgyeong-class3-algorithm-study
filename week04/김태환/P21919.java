import java.util.ArrayList;
import java.util.List;

class P21919 {
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
		
		List<Integer> prime = new ArrayList<>();
		int N = read();
		
		while (N-- > 0) {
			int a = read();
			
			if (isNotPrime[a]) {
				continue;
			}
			
			prime.add(a);
		}
		
		if (prime.size() == 0) {
			System.out.println("-1");
			
		} else if (prime.size() == 1) {
			System.out.println(prime.get(0));
			
		} else {
			long a = prime.get(0);
			
			for (int i = 1; i < prime.size(); i++) {
				int b = prime.get(i);
				a = a * b / gcd(a, b);
			}
			
			System.out.println(a);
		}
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
	
	private static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}

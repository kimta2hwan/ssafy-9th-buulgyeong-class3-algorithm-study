import java.util.Arrays;

class P14247 {
	public static void main(String[] args) throws Exception {
		int n = read();
		long answer = 0;
		
		for (int i = 0; i < n; i++) {
			answer += read();
		}
		
		int[] A = new int[n];
		
		for (int i = 0; i < n; i++) {
			A[i] = read();
		}
		
		Arrays.sort(A);
		
		for (int i = 0; i < n; i++) {
			answer += A[i] * i;
		}
		
		System.out.println(answer);
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

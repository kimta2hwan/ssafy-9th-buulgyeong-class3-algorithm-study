import java.util.Arrays;

class P2212 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int K = read();
		
		if (K >= N) {
			System.out.println(0);
			return;
		}
		
		int[] sensor = new int[N];
		
		for (int i = 0; i < N; i++) {
			sensor[i] = read();
		}
		
		Arrays.sort(sensor);
		int[] diff = new int[N - 1];
		
		for (int i = 0; i < N - 1; i++) {
			diff[i] = sensor[i + 1] - sensor[i];
		}
		
		Arrays.sort(diff);
		int result = 0;
		
		for (int i = 0; i < N - K; i++) {
			result += diff[i];
		}
		
		System.out.println(result);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean isNegative = n == 13;
		
		if (isNegative) {
			n = System.in.read() & 15;
		}
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}

        if (c == 13) {
            System.in.read();
        }
		
		return isNegative ? ~n + 1 : n;
	}
}

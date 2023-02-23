import java.util.Arrays;

class P13164 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int K = read();
		int[] student = new int[N];
		
		for (int i = 0; i < N; i++) {
			student[i] = read();
		}
		
		int[] diff = new int[N - 1];
		
		for (int i = 1; i < N; i++) {
			diff[i - 1] = student[i] - student[i - 1];
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
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}

        if (c == 13) {
            System.in.read();
        }
		
		return n;
	}
}

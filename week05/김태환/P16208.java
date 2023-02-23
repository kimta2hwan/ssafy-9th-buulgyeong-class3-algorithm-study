import java.util.Arrays;

class P16208 {
	public static void main(String[] args) throws Exception {
		int n = read();
		int[] a = new int[n];
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			a[i] = read();
			sum += a[i];
		}
		
		Arrays.sort(a);
		long answer = 0;
		
		for (int i = 0; i < n - 1; i++) {
			sum -= a[i];
			answer += sum * a[i];
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

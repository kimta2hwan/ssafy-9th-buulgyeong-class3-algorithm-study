import java.util.Arrays;

class P11399 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = read();
		}
		
		Arrays.sort(arr);
		int sum = arr[0];
		
		for (int i = 1; i < N; i++) {
			arr[i] = arr[i] + arr[i - 1];
			sum += arr[i];
		}
		
		System.out.println(sum);
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

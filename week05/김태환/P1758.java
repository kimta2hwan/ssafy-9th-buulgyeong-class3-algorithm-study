import java.util.Arrays;

class P1758 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = read();
		}
		
		Arrays.sort(arr);
		int index = 0;
		long sum = 0;
		
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] - index <= 0) {
				break;
			}
			
			sum += arr[i] - index++;
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

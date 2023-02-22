import java.util.Arrays;

class P20300 {
	public static void main(String[] args) throws Exception {
		int N = readInt();
		long[] arr = new long[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = readLong();
		}
		
		Arrays.sort(arr);
		long max = 0;
		int j;
		
		if (arr.length % 2 == 0) {
			j = arr.length - 1;
			
		} else {
			max = arr[arr.length - 1];
			j = arr.length - 2;
		}
		
		for (int i = 0; i < j; i++, j--) {
			long sum = arr[i] + arr[j];
			
			if (sum > max) {
				max = sum;
			}
		}
		
		System.out.println(max);
	}
	
	private static int readInt() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}

        if (c == 13) {
            System.in.read();
        }
		
		return n;
	}
	
	private static long readLong() throws Exception {
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
}

import java.util.Arrays;

class P11256 {
	
	public static void main(String[] args) throws Exception {
		int T = read();
		
		while (T-- > 0) {
			int J = read();
			int N = read();
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = read() * read();
			}
			
			Arrays.sort(arr);
			
			int count = 0;
			int index = N - 1;
			
			while (J > 0) {
				J -= arr[index--];
				count++;
			}
			
			System.out.println(count);
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
}

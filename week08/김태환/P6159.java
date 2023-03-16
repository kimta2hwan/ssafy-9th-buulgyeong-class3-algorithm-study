import java.util.Arrays;

class P6159 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int S = read();
		
		int[] cow = new int[N];
		
		for (int i = 0; i < N; i++) {
			cow[i] = read();
		}
		
		Arrays.sort(cow);

		int count = 0;
		int leftPointer = 0;
		int rightPointer = N - 1;
		
		while (leftPointer < rightPointer) {
			int left = cow[leftPointer];
			int right = cow[rightPointer];
			
			if (right + left <= S) {
				count += rightPointer - leftPointer;
				leftPointer++;
				
			} else {
				rightPointer--;
			}
		}
		
		System.out.print(count);
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

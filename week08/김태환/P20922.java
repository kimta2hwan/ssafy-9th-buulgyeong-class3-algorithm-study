class P20922 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int K = read();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = read();
		}
		
		int[] counting = new int[100001];
		int rightPointer = 0;
		int leftPointer = 0;
		int max = 0;
		
		while (rightPointer < N) {
			while (rightPointer < N && counting[arr[rightPointer]] + 1 <= K) {
				counting[arr[rightPointer]]++;
				rightPointer++;
			}
			
			int length = rightPointer - leftPointer;
			
			if (length > max) {
				max = length;
			}
			
			counting[arr[leftPointer]]--;
			leftPointer++;
		}
		
		System.out.println(max);
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

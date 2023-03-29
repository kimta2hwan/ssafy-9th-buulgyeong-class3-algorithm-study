class P2003 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int M = read();
		
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = read();
		}
		
		int leftPointer = -1;
		int rightPointer = 0;
		int sum = A[rightPointer];
		int count = 0;
		
		while (leftPointer < N) {
			if (sum <= M) {
				if (sum == M) {
					count++;
				}
				
				if (rightPointer + 1 >= N) {
					break;
				}
				
				sum += A[++rightPointer];
				
			} else {
				sum -= A[++leftPointer];
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

class P11728 {
	
	private static class Heap {
		int[] heap;
		int size;
		
		public Heap(int size) {
			this.heap = new int[size + 1];
		}
		
		void offer(int x) {
			heap[++size] = x;
			int i = size << 1;
			
			while ((i >>= 1) > 1) {
				if (!swap(i)) {
					break;
				}
			}
		}
		
		int poll() {
			int x = heap[1];
			heap[1] = heap[size--];
			int i = 1;
			
			while ((i <<= 1) <= size) {
				if (i < size && heap[i + 1] < heap[i]) {
					i++;
				}
				
				if (!swap(i)) {
					break;
				}
			}
			
			return x;
		}
		
		boolean swap(int i) {
			int j = i >> 1;
			int parent = heap[j];
			int child = heap[i];
			
			if (parent < child) {
				return false;
			}
			
			heap[j] = child;
			heap[i] = parent;
			
			return true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int N = read();
		int M = read();
		
		Heap heap = new Heap(N + M);
		
		for (int i = 0; i < N; i++) {
			heap.offer(read());
		}
		
		for (int i = 0; i < M; i++) {
			heap.offer(read());
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (heap.size > 0) {
			sb.append(heap.poll()).append(' ');
		}
		
		System.out.println(sb);
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

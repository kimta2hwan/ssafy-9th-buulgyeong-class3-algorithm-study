class P16435 {
	
	static class Heap {
		int[] heap;
		int size;
		
		public Heap(int size) {
			heap = new int[size + 1];
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
			if (size == 0) {
				return 0;
			}
			
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
		int L = read();
		
		Heap heap = new Heap(N);
		
		while (N-- > 0) {
			heap.offer(read());
		}
		
		while (heap.size != 0 && heap.heap[1] <= L) {
			heap.poll();
			L++;
		}
		
		System.out.println(L);
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

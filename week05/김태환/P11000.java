import java.util.Arrays;

class P11000 {
	
	static class Heap {
		int[] heap;
		int size;
		
		public Heap(int size) {
			heap = new int[size + 1];
		}
		
		void offer(int lecter) {
			heap[++size] = lecter;
			int i = size << 1;
			
			while ((i >>= 1) > 1) {
				if (!swap(i)) {
					break;
				}
			}
		}
		
		int poll() {
			int lecter = heap[1];
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
			
			return lecter;
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
		int[][] lecture = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			lecture[i][0] = read();
			lecture[i][1] = read();
		}
		
		Arrays.sort(lecture, (l1, l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
		
		Heap heap = new Heap(N);
		heap.offer(lecture[0][1]);
		
		for (int i = 1; i < N; i++) {
			if (heap.heap[1] <= lecture[i][0]) {
				heap.poll();
			}
			
			heap.offer(lecture[i][1]);
		}
		
		System.out.println(heap.size);
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

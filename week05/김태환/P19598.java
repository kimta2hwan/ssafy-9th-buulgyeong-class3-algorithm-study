import java.util.Arrays;

class P19598 {
	
	static class Heap {
		int[] endTimes;
		int size;
		
		public Heap(int size) {
			this.endTimes = new int[size + 1];
		}
		
		void offer(int endTime) {
			endTimes[++size] = endTime;
			int i = size << 1;
			
			while ((i >>= 1) > 1) {
				if (!swap(i)) {
					break;
				}
			}
		}
		
		int poll() {
			int endTime = endTimes[1];
			endTimes[1] = endTimes[size--];
			int i = 1;
			
			while ((i <<= 1) <= size) {
				if (i < size && endTimes[i + 1] < endTimes[i]) {
					i++;
				}
				
				if (!swap(i)) {
					break;
				}
			}
			
			return endTime;
		}
		
		boolean swap(int i) {
			int j = i >> 1;
			int parent = endTimes[j];
			int child = endTimes[i];
			
			if (parent < child) {
				return false;
			}
			
			endTimes[j] = child;
			endTimes[i] = parent;
			
			return true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int N = read();
		
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			arr[i][0] = read();
			arr[i][1] = read();
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		Heap heap = new Heap(N);
		
		heap.offer(arr[0][1]);
		
		for (int i = 1; i < N; i++) {
			if (heap.endTimes[1] <= arr[i][0]) {
				heap.poll();
			}
			
			heap.offer(arr[i][1]);
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

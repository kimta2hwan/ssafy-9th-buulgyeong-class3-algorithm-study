import java.util.LinkedList;

class P1021 {
	public static void main(String[] args) throws Exception {
		LinkedList<Integer> deque = new LinkedList<>();
		int N = read();
		
		for (int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		int M = read();
		int count = 0;
		
		while (M-- > 0) {
			int target = deque.indexOf(read());
			int index = deque.size() % 2 == 0 ? deque.size() / 2 - 1 : deque.size() / 2;
			
			if (target <= index) {
				for (int j = 0; j < target; j++) {
					deque.offer(deque.pollFirst());
					count++;
				}
				
			} else {
				for (int j = 0; j < deque.size() - target; j++) {
					deque.offerFirst(deque.pollLast());
					count++;
				}
			}
			
			deque.pollFirst();
		}
		
		System.out.println(count);
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

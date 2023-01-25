import java.util.LinkedList;
import java.util.Queue;

class P2164 {
	public static void main(String[] args) throws Exception {
		Queue<Integer> queue = new LinkedList<>();
		int N = read();
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		while (queue.size() > 1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		
		System.out.println(queue.poll());
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

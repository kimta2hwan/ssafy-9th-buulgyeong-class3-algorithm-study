import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;

public class P11286 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			if (Math.abs(a) - Math.abs(b) == 0) {
				return a - b;
			}
			return Math.abs(a) - Math.abs(b);
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				pq.offer(x);
			} else {
				if (pq.size() == 0) {
					sb.append(0).append('\n');
				} else {
					sb.append(pq.poll()).append('\n');
				}

			}
		}
		System.out.println(sb);
	}

}
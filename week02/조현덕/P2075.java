import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2075 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer st;
		// 큰 수 갱신하면서 N개 저장하면
		// 마지막에 남은 것중에 가장 작은 것이 N번째로 큰 수 이다
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int x = Integer.parseInt(st.nextToken());
				// N개보다 작으면 그냥 넣음
				if (pq.size() < N) {
					pq.offer(x);
				} else {
					// N개 이상이면 가장작은 수와 비교해서 크면 빼고 넣는다
					if (pq.peek() < x) {
						pq.poll();
						pq.offer(x);
					}
				}
			}
		}
		System.out.println(pq.poll());
	}

}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class P2696 {
	// max는 중앙값 미만, min은 중앙값 이상 집어 넣음
	static PriorityQueue<Integer> maxpq;
	static PriorityQueue<Integer> minpq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 0; test < T; test++) {
			int M = Integer.parseInt(br.readLine());

			minpq = new PriorityQueue<>();
			maxpq = new PriorityQueue<Integer>(Collections.reverseOrder());

			StringTokenizer st = null;
			StringBuilder sb = new StringBuilder();
			
			// 출력 10개 세기위한 용도
			int count = 0;

			// 전체 중앙값 개수
			sb.append((M + 1) / 2).append("\n");

			for (int i = 1; i <= M; i++) {
				if (i % 10 == 1) {
					st = new StringTokenizer(br.readLine());
				}

				// min max 비교해서 size가 같으면 min에 넣고, 아니면 max
				// 홀수번째 min이 하나 더 많도록
				if (minpq.size() == maxpq.size()) {
					minpq.offer(Integer.parseInt(st.nextToken()));
				} else {
					maxpq.offer(Integer.parseInt(st.nextToken()));
				}

				// 중앙값을 맞춰 줘야한다.
				// minpq의 root값과 maxpq의 root값을 비교해서 maxpq가 minpq보다 크다면 서로 값을 바꿔 넣어준다.
				if (!maxpq.isEmpty()) {
					if (minpq.peek() < maxpq.peek()) {
						int tmp1 = maxpq.poll();
						int tmp2 = minpq.poll();

						maxpq.offer(tmp2);
						minpq.offer(tmp1);
					}
				}

				// 홀수 일 때
				if (i % 2 == 1) {
					if (count == 10) {
						sb.append("\n");
						count = 0;
					}
					sb.append(minpq.peek()).append(" ");
					count++;
				}
			}

			System.out.println(sb);
		}

	}
}
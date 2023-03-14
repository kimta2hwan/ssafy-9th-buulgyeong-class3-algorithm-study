import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14567 {
	static int N, M;
	static List<Integer>[] lecture;
	static int[] inDegree;
	static int[] ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		inDegree = new int[N + 1];
		lecture = new ArrayList[N + 1];
		ans = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			lecture[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			lecture[A].add(B);
			inDegree[B]++;
		}

		topologySort();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(ans[i]).append(" ");
		}
		
		System.out.println(sb);
	}

	static void topologySort() {
		Queue<int[]> queue = new ArrayDeque<>();
		// 진입 차수가 0인 것을 queue에 넣음
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				queue.offer(new int[] { i, 1 });
			}
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			ans[cur[0]] = cur[1];

			for (int n : lecture[cur[0]]) {
				inDegree[n]--;

				if (inDegree[n] == 0) {
					queue.offer(new int[] { n, cur[1] + 1 });
				}
			}
		}
	}

}

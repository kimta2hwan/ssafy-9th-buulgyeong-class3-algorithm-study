import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1967 {
	static int n, max, maxIdx;
	static List<int[]>[] edge;
	static boolean[] isVisited;

	static void dfs(int node, int sum) {
		if (max < sum) {
			max = sum;
			maxIdx = node;
		}

		for (int[] e : edge[node]) {
			if (!isVisited[e[0]]) {
				isVisited[e[0]] = true;
				dfs(e[0], sum + e[1]);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		edge = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			edge[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edge[from].add(new int[] { to, weight });
			edge[to].add(new int[] { from, weight });
		}

		// 어떤 정점에서 가장 긴 거리의 정점을 구하고
		// 그 정점에서 다시 가장 긴 거리의 정점을 구하면 그것이 트리의 지름이다.

		max = 0;
		isVisited = new boolean[n + 1];
		isVisited[1] = true;
		dfs(1, 0);

		max = 0;
		isVisited = new boolean[n + 1];
		isVisited[maxIdx] = true;
		dfs(maxIdx, 0);
		System.out.println(max);
	}

}

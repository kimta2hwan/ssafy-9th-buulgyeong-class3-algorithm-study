import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
// 트리의 부모 찾기
public class P11725 {
	static int N;
	static int[] parent;
	static boolean[] visited;
	static List<List<Integer>> tree = new ArrayList<>();
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; ++i)
			tree.add(new ArrayList<>());

		StringTokenizer st;

		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			tree.get(v1).add(v2);
			tree.get(v2).add(v1);
		}

		queue.add(0);
		visited[0] = true;

		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (int node : tree.get(v)) {
				if (visited[node])
					continue;
				visited[node] = true;
				queue.add(node);
				parent[node] = v;
			}
		}

		for (int i = 1; i < N; ++i) {
			System.out.println(parent[i] + 1);
		}

	}

}

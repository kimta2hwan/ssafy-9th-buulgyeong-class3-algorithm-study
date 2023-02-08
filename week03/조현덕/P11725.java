import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P11725 {
	static int N;
	static List<List<Integer>> node;
	static boolean[] isVisited;
	static int[] parent;

	public static void dfs(int startNode) {
//		// 방문했던 노드는 탐색하지 않는다
//		if(isVisited[startNode]) {
//			return;
//		}

		// 방문
		isVisited[startNode] = true;

		for (int n : node.get(startNode)) {
			if (!isVisited[n]) {
				parent[n] = startNode;
				dfs(n);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		// node 초기화
		node = new ArrayList<List<Integer>>();
		for (int i = 0; i <= N; i++) {
			node.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			// 연결된 선 등록
			node.get(node1).add(node2);
			node.get(node2).add(node1);
		}

		isVisited = new boolean[N + 1];
		parent = new int[N + 1];

		dfs(1);
		StringBuilder sb = new StringBuilder();

		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}
}
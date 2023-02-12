import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P3584 {
	static int T, N;
	static List<Integer>[] edge;
	static int[] depths, parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {

			N = Integer.parseInt(br.readLine());
			edge = new ArrayList[N + 1];
			for (int i = 0; i <= N; i++) {
				edge[i] = new ArrayList<>();
			}

			StringTokenizer st;

			// root 노드를 구하자
			// to에 안나오는 node가 root
			boolean[] noRoot = new boolean[N + 1];
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				noRoot[to] = true;
				edge[from].add(to);
				edge[to].add(from);
			}

			int root = 0;
			for (int i = 1; i <= N; i++) {
				if (!noRoot[i]) {
					root = i;
					break;
				}
			}

			// 공통 조상을 구할 두 노드
			st = new StringTokenizer(br.readLine());
			int nA = Integer.parseInt(st.nextToken());
			int nB = Integer.parseInt(st.nextToken());

			// 깊이를 구하고
			depths = new int[N + 1];
			parents = new int[N + 1];
			depths = new int[N + 1];
			cal_depth(root, 1, 0);

			System.out.println(LCA(nA, nB));

		}

	}

	static void cal_depth(int node, int depth, int parent) {
		depths[node] = depth;
		parents[node] = parent;
		for (int next_node : edge[node]) {
			if (next_node != parent) {
				cal_depth(next_node, depth + 1, node);
			}
		}
	}
	
	static int LCA(int a, int b) {
		// depth 일치
		while(depths[a] != depths[b]) {
			if (depths[a] > depths[b]) {
                a = parents[a];
            } else {
                b = parents[b];
            }
		}
		
		// 같은 노드 나올때 까지 +1
		while(a!=b) {
			a = parents[a];
			b = parents[b];
		}
		return a;
	}
	

}

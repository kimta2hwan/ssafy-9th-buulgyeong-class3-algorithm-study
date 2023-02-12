import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P17073 {
	static int N, W, leafnodeCnt;
	static List<Integer>[] edge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		edge = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			edge[i] = new ArrayList<>();
		}

		// 노드 끼리의 연결성을 나타냄
		for (int i = 1; i <= N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			edge[u].add(v);
			edge[v].add(u);
		}

		// edge가 1개인 노드가 leaf 노드
		for (int i = 2; i <= N; i++) {
			if (edge[i].size() == 1) {
				leafnodeCnt++;
			}
		}

		System.out.println((double) W / leafnodeCnt);
	}

}

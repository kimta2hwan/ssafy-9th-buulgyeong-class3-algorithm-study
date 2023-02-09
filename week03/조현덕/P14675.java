import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P14675 {
	static int N, q; // 트리의 정점 개수
	static List<Integer>[] edge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		edge = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			edge[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			edge[a].add(b);
			edge[b].add(a);
		}

		q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if (t == 1) {
				// 단절점 확인
				// 제거하는 node와 연결된 다른 노드 사이를 이동할 수 있는 경로가 있다면 단절점이 아니다.
				// tree에서는 리프노드를 제거하는 것이 아니라면 전부 단절점이다.
				// 리프 노드인가를 check하면 됨 <= 연결된 노드가 1개
				if(edge[k].size() == 1) {
					sb.append("no").append("\n");
				}else {
					sb.append("yes").append("\n");
				}				
			} else {
				// 단절선 확인
				// tree는 전부 단절선이다
				sb.append("yes").append("\n");
			}

		}
		System.out.println(sb);

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1068 {
	static int N, q; // 트리의 정점 개수
	static List<Integer>[] edge; // 각 노드에서 자식노드 저장
	static int COUNT;
	static int delete; // 없어질 노드
	
	static void bfs(int node) {
		// 다음으로 가는 edge가 없으면 leaf노드이다.
		if(edge[node].size()==0) {
			COUNT++;
			return;
		}
		// edge가 있지만 도착 노드가 delete 노드인 경우
		if(edge[node].size()==1) {
			if(edge[node].get(0) == delete) {
				COUNT++;
				return;
			}
		}
		
		// 갈수있는 node 전부 탐색
		for(int n : edge[node]) {
			if(n != delete) {
				bfs(n);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		edge = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			edge[i] = new ArrayList<>();
		}
		
		// 루트의 index를 저장
		int root = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int node = Integer.parseInt(st.nextToken());
			if (node != -1) {
				edge[node].add(i);
			}else {
				root = i;
			}
		}
		
		// 없어질 node
		delete = Integer.parseInt(br.readLine());
		if(delete != root) {
			bfs(root);
		}
		System.out.println(COUNT);
	}

}

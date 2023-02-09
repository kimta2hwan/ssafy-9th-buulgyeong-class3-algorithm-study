import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1991 {
	static int N;
	// key = root, value = (left, right)
	static Map<String, String[]> edge;
	static StringBuilder preorder = new StringBuilder();
	static StringBuilder inorder = new StringBuilder();
	static StringBuilder postorder = new StringBuilder();

	public static void dfs(String startNode) {
		if(startNode.equals(".")) {
			return;
		}
		// 루트
		// 루트 먼저 찍기
		preorder.append(startNode);
		
		// 왼쪽
		String left = edge.get(startNode)[0];
		dfs(left);
		
		// 루트 중간에 찍기
		inorder.append(startNode);
		
		// 오른쪽
		String right = edge.get(startNode)[1];
		dfs(right);
		
		// 루트 마지막에 찍기
		postorder.append(startNode);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// edge를 추가
		edge = new HashMap<>();
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
			edge.put(root, new String[] {left, right});
		}
		
		dfs("A");
		System.out.println(preorder);
		System.out.println(inorder);
		System.out.println(postorder);
		
	}
}

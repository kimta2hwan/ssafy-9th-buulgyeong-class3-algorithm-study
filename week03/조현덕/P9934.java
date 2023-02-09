import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P9934 {
	static int K;
	static int[] node;
	static List<List<Integer>> result;

	static void tree(int depth, int[] subTree) {
		if (depth == K) {
			return;
		}

		// 중앙을 기준으로 나눔
		int mid = subTree.length / 2;
		result.get(depth).add(subTree[mid]);

		// left
		tree(depth + 1, Arrays.copyOfRange(subTree, 0, mid));
		// right
		tree(depth + 1, Arrays.copyOfRange(subTree, mid + 1, subTree.length));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 깊이가 K인 완전 이진 트리
		K = Integer.parseInt(br.readLine());

		// 깊이가 K이면 총 노드의 수는 2^K-1
		node = new int[(int) (Math.pow(2, K)) - 1];

		// inorder의 순서로 입력을 받는다
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < node.length; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}

		result = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			result.add(new ArrayList<>());
		}

		tree(0, node);
		
		StringBuilder sb = new StringBuilder();
		for(List<Integer> l : result) {
			for(int n : l) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}

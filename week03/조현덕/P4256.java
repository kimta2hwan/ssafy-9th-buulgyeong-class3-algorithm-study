import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P4256 {

	static int T, n;
	static int[] preorder, inorder, inorderNumIndex;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());

			preorder = new int[n];
			inorder = new int[n];
			inorderNumIndex = new int[n + 1]; // preorder의 root를 inorder에서 찾아야하는데, 반복해서 순차탐색하는 것을 방지

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				preorder[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());
				inorder[i] = num;
				inorderNumIndex[num] = i;
			}

			// preorder에서 처음 수는 root이다
			// inorder에서 수를 찾는다. 그 전의 수는 전부 root의 왼쪽
			// 다음 preoder에서 처음 수는 왼쪽의 root이다. 반복
			// 왼쪽에서 다찾으면 오른쪽 반복

			find_tree(0, 0, n);
			sb.append("\n");
		}
		System.out.println(sb);

	}

	/**
	 * 
	 * @param preIndex preorder index
	 * @param from     inorder에서 탐색범위
	 * @param to       inorder에서 탐색범위
	 */
	static void find_tree(int preIndex, int from, int to) {
		if (preIndex >= n || from == to) {
			return;
		}

		int root = preorder[preIndex];
		int inIdx = inorderNumIndex[root];
		if (inIdx >= to || inIdx < from) {
			sb.append(preorder[preIndex]).append(" ");
			return;
		}
//		if (inIdx == from) {
//			sb.append(preorder[preIndex]).append(" ");
//			return;
//		}

		find_tree(preIndex + 1, from, inIdx);
		find_tree(preIndex + inIdx - from + 1, inIdx + 1, to);
		sb.append(preorder[preIndex]).append(" ");
	}

}

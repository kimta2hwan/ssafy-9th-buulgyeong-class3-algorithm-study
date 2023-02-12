import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991 {
	static int N;
	static Node head = new Node('A', null, null);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			insertNode(head, root, left, right);
		}
		
		preOrder(head);
		sb.append('\n');
		inOrder(head);
		sb.append('\n');
		postOrder(head);
		System.out.println(sb);

	}

	static class Node {
		char val;
		Node left;
		Node right;

		public Node(char val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

	}

	public static void insertNode(Node tmp, char root, char left, char right) {

		if (tmp.val == root) {
			tmp.left = left == '.' ? null : new Node(left, null, null);
			tmp.right = right == '.' ? null : new Node(right, null, null);
		} else {
			if (tmp.left != null)
				insertNode(tmp.left, root, left, right);
			if (tmp.right != null)
				insertNode(tmp.right, root, left, right);
		}
	}

	public static void preOrder(Node node) {
		if (node == null)
			return;
		sb.append(node.val);
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		sb.append(node.val);
		inOrder(node.right);
	}

	public static void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.val);
	}

}

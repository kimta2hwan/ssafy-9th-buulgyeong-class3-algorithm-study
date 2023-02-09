import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class P5369 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));
		while (true) {
			String s = br.readLine();
			if (s == null || s.equals("")) {
				break;
			}
			int n = Integer.parseInt(s);
			root.insert(n);
		}

		postorder(root);
		System.out.println(sb);
	}

	static void postorder(Node node) {
		if (node == null) {
			return;
		}
		// left
		postorder(node.left);
		// right
		postorder(node.right);
		sb.append(node.num).append("\n");
	}

	static class Node {
		int num;
		Node left;
		Node right;

		public Node(int num) {
			this.num = num;
		}

		public void insert(int num) {
			if (this.num > num) {
				if (left == null) {
					this.left = new Node(num);
				} else {
					left.insert(num);
				}
			} else {
				if (right == null) {
					this.right = new Node(num);
				} else {
					right.insert(num);
				}
			}
		}
	}

}

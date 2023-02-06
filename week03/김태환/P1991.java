class P1991 {
	
	static class Node {
		char c;
		Node leftNode;
		Node rightNode;
		
		Node(char c) {
			this.c = c;
		}
		
		void setLeft(int n) {
			if (n == 46) {
				return;
			}
			
			this.leftNode = tree[n - 'A'];
		}
		
		void setRight(int n) {
			if (n == 46) {
				return;
			}
			
			this.rightNode = tree[n - 'A'];
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static Node[] tree;
	
	public static void main(String[] args) throws Exception {
		int N = read();
		tree = new Node[N];
		
		for (int i = 0; i < N; i++) {
			tree[i] = new Node((char) (i + 'A'));
		}
		
		while (N-- > 0) {
			Node node = tree[System.in.read() - 'A'];
			System.in.read();
			node.setLeft(System.in.read());
			System.in.read();
			node.setRight(System.in.read());
			System.in.read();
		}
		
		preorderTraverse(tree[0]);
		sb.append('\n');
		inorderTraverse(tree[0]);
		sb.append('\n');
		postorderTraverse(tree[0]);
		
		System.out.println(sb);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}

        if (c == 13) {
            System.in.read();
        }
		
		return n;
	}
	
	private static void preorderTraverse(Node node) {
		sb.append(node.c);
		
		if (node.leftNode != null) {
			preorderTraverse(node.leftNode);
		}
		
		if (node.rightNode != null) {
			preorderTraverse(node.rightNode);
		}
	}
	
	private static void inorderTraverse(Node node) {
		if (node.leftNode != null) {
			inorderTraverse(node.leftNode);
		}
		
		sb.append(node.c);
		
		if (node.rightNode != null) {
			inorderTraverse(node.rightNode);
		}
	}
	
	private static void postorderTraverse(Node node) {
		if (node.leftNode != null) {
			postorderTraverse(node.leftNode);
		}
		
		if (node.rightNode != null) {
			postorderTraverse(node.rightNode);
		}
		
		sb.append(node.c);
	}
}

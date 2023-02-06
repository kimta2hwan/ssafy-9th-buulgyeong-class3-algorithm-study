import java.util.ArrayList;
import java.util.List;

class P11725 {
	
	static List<List<Integer>> tree;
	static boolean[] visited;
	static int[] parents;
	static int N;
	
	public static void main(String[] args) throws Exception {
		N = read();
		tree = new ArrayList<>(N + 1);
		
		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}
		
		for (int i = 1; i < N; i++) {
			int from = read();
			int to = read();
			
			tree.get(from).add(to);
			tree.get(to).add(from);
		}
		
		visited = new boolean[N + 1];
		parents = new int[N + 1];
		
		bfs();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 2; i <= N; i++) {
			sb.append(parents[i]).append('\n');
		}
		
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
	
	private static void bfs() {
		int[] queue = new int[N];
		int head = 0;
		int tail = -1;
		
		visited[1] = true;
		queue[++tail] = 1;
		
		while (tail > head - 1) {
			int parent = queue[head++];
			
			for (int child : tree.get(parent)) {
				if (visited[child]) {
					continue;
				}
				
				parents[child] = parent;
				visited[child] = true;
				queue[++tail] = child;
			}
		}
	}
}

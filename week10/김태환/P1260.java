import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class P1260 {
	
	static List<Integer>[] list;
	static StringBuilder sb;
	static boolean[] visited;
	static int N;
	
	public static void main(String[] args) throws Exception {
		N = read();
		int M = read();
		int V = read();
		
		list = new List[N + 1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		while (M-- > 0) {
			int from = read();
			int to = read();
			
			list[from].add(to);
			list[to].add(from);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		sb = new StringBuilder();
		visited = new boolean[N + 1];
		dfs(V);
		
		sb.append('\n');
		visited = new boolean[N + 1];
		bfs(V);
		
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
	
	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(' ');
		
		for (int i : list[v]) {
			if (visited[i]) {
				continue;
			}
			
			dfs(i);
		}
	}
	
	private static void bfs(int v) {
		int[] queue = new int[N];
		int head = 0;
		int tail = -1;
		
		sb.append(v).append(' ');
		visited[v] = true;
		queue[++tail] = v;
		
		while (tail > head - 1) {
			int next = queue[head++];
			
			for (int i : list[next]) {
				if (visited[i]) {
					continue;
				}
				
				sb.append(i).append(' ');
				visited[i] = true;
				queue[++tail] = i;
			}
		}
	}
}

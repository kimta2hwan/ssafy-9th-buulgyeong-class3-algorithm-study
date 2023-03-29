import java.util.ArrayList;
import java.util.List;

class P1325 {
	
	private static List<List<Integer>> list;
	private static boolean[] visited;
	private static int[] queue;
	private static int[] dp;
	private static int N;
	
	public static void main(String[] args) throws Exception {
		N = read();
		int M = read();
		
		list = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		while (M-- > 0) {
			list.get(read()).add(read());
		}
		
		dp = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		
		int max = 0;
		
		for (int i = 1; i <= N; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			if (dp[i] == max) {
				sb.append(i).append(' ');
			}
		}
		
		System.out.print(sb);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
	
	private static void bfs(int n) {
		visited = new boolean[N + 1];
		queue = new int[N];
		
		int head = 0;
		int tail = -1;
		
		visited[n] = true;
		queue[++tail] = n;
		
		while (tail > head - 1) {
			int curr = queue[head++];
			
			for (int next : list.get(curr)) {
				if (visited[next]) {
					continue;
				}
				
				visited[next] = true;
				queue[++tail] = next;
				dp[next]++;
			}
		}
	}
}

import java.util.ArrayList;
import java.util.List;

class P2606 {
	
	private static List<List<Integer>> list;
	private static boolean[] visited;
	private static int count = 0;
	
	public static void main(String[] args) throws Exception {
		int n = read();
		int m = read();
		
		list = new ArrayList<>();
		visited = new boolean[n + 1];
		
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		while (m-- > 0) {
			int from = read();
			int to = read();
			
			list.get(from).add(to);
			list.get(to).add(from);
		}
		
		dfs(1);
		System.out.print(count);
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
	
	private static void dfs(int n) {
		visited[n] = true;
		
		for (int next : list.get(n)) {
			if (visited[next]) {
				continue;
			}
			
			dfs(next);
			count++;
		}
	}
}

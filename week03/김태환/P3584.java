class P3584 {
	
	static int[] parents;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int T = read();
		
		while (T-- > 0) {
			int N = read();
			
			parents = new int[N + 1];
			visited = new boolean[N + 1];
			
			while (N-- > 1) {
				int A = read();
				int B = read();
				
				parents[B] = A;
			}
			
			int A = read();
			int B = read();
			
			dfs(A);
			
			while (!visited[B]) {
				B = parents[B];
			}
			
			sb.append(B).append('\n');
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
	
	private static void dfs(int node) {
        visited[node] = true;

        if (parents[node] != 0) {
            dfs(parents[node]);
        }
    }
}

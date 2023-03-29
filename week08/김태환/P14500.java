class P14500 {
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static boolean[][] visited;
	private static int[][] map;
	private static int N, M, max;
	
	public static void main(String[] args) throws Exception {
		N = read();
		M = read();
		
		visited = new boolean[N][M];
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = read();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, map[i][j], 1);
				visited[i][j] = false;
			}
		}
		
		System.out.print(max);
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
	
	private static void dfs(int r, int c, int sum, int count) {
		if (count == 4) {
			if (sum > max) {
				max = sum;
			}
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
				continue;
			}
			
			visited[nr][nc] = true;
			
			if (count == 2) {
				dfs(r, c, sum + map[nr][nc], count + 1);
			}
			
			dfs(nr, nc, sum + map[nr][nc], count + 1);
			visited[nr][nc] = false;
		}
	}
}

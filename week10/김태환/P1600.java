import java.util.ArrayDeque;
import java.util.Queue;

class P1600 {
	
	private static class Point {
		int r;
		int c;
		int k;
		int count;
		
		public Point(int r, int c, int k, int count) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.count = count;
		}
	}
	
	private static int[] hdr = {-2, -2, -1, 1, 2, 2, 1, -1};
	private static int[] hdc = {-1, 1, 2, 2, 1, -1, -2, -2};
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static int[][] map;
	private static int K, H, W;
	
	public static void main(String[] args) throws Exception {
		K = read();
		W = read();
		H = read();
		map = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = read();
			}
		}
		
		System.out.print(bfs());
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
	
	private static int bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][][] visited = new boolean[K + 1][H][W];
		
		queue.offer(new Point(0, 0, K, 0));
		visited[K][0][0] = true;
		
		while (!queue.isEmpty()) {
			Point curr = queue.poll();
			
			if (curr.r == H - 1 && curr.c == W - 1) {
				return curr.count;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nr >= H || nc < 0 || nc >= W || visited[curr.k][nr][nc] || map[nr][nc] == 1) {
					continue;
				}
				
				queue.offer(new Point(nr, nc, curr.k, curr.count + 1));
				visited[curr.k][nr][nc] = true;
			}
			
			if (curr.k > 0) {
				for (int i = 0; i < 8; i++) {
					int nr = curr.r + hdr[i];
					int nc = curr.c + hdc[i];
					
					if (nr < 0 || nr >= H || nc < 0 || nc >= W || visited[curr.k - 1][nr][nc] || map[nr][nc] == 1) {
						continue;
					}
					
					queue.offer(new Point(nr, nc, curr.k - 1, curr.count + 1));
					visited[curr.k - 1][nr][nc] = true;
				}
			}
		}
		
		return -1;
	}
}

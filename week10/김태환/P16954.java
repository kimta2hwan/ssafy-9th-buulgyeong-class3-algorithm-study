import java.util.ArrayDeque;
import java.util.Queue;

class P16954 {
	
	private static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	private static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0, 0};
	private static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
	private static byte[][] map = new byte[8][9];
	private static int wallCount = 0;
	
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 8; i++) {
			System.in.read(map[i]);
		}
		
		for (int i = 7; i >= 1; i--) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == 35) {
					wallCount++;
				}
			}
		}
		
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visited;
		queue.offer(new Point(7, 0));
		
		while (!queue.isEmpty()) {
			if (wallCount == 0) {
				System.out.print(1);
				return;
			}
			
			visited = new boolean[8][8];
			int size = queue.size();
			
			while (size-- > 0) {
				Point curr = queue.poll();
				
				if (map[curr.r][curr.c] == 35) {
					continue;
				}
				
				if (curr.r == 7 && curr.c == 7) {
					System.out.print(1);
					return;
				}
				
				for (int i = 0; i < 9; i++) {
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];
					
					if (nr < 0 || nr > 7 || nc < 0 || nc > 7 || visited[nr][nc] || map[nr][nc] == 35) {
						continue;
					}
					
					queue.offer(new Point(nr, nc));
					visited[nr][nc] = true;
				}
			}
			
			moveWall();
		}
		
		System.out.println(0);
	}
	
	private static void moveWall() {
		int count = 0;
		
		for (int i = 7; i >= 1; i--) {
			for (int j = 0; j < 8; j++) {
				map[i][j] = map[i - 1][j];
				
				if (map[i][j] == 35) {
					count++;
				}
			}
		}
        
        for (int i = 0; i < 8; i++) {
			map[0][i] = 46;
		}
		
		wallCount = count;
	}
}

import java.util.ArrayDeque;
import java.util.Queue;

class P4179 {
	
	private static class Point {
		int r;
		int c;
		int turn;
		
		public Point(int r, int c, int turn) {
			this.r = r;
			this.c = c;
			this.turn = turn;
		}
	}
    
    public static void main(String[] args)throws Exception{
        int R = read();
        int C = read();
        
        byte[][] map = new byte[R][C + 1];
		
		for (int i = 0; i < R; i++) {
			System.in.read(map[i]);
		}
        
		Queue<Point> queue = new ArrayDeque<>();
		int startX = 0;
		int startY = 0;
        
        for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 74) {
					startX = i;
                    startY = j;
					
				} else if (map[i][j] == 70) {
					queue.add(new Point(i, j, 0));
				}
			}
		}
        
        queue.add(new Point(startX, startY, 0));
        
        int[] dr = {-1, 1, 0, 0};
    	int[] dc = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
			Point curr = queue.poll();
				
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
					
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
					if (map[curr.r][curr.c] == 74) {
						System.out.println(curr.turn + 1);
						return;
					}
					
					continue;
				}
				
				if (map[nr][nc] != 46) {
					continue;
				}
					
				queue.offer(new Point(nr, nc, curr.turn + 1));
				map[nr][nc] = map[curr.r][curr.c];
			}
		}
		
		System.out.print("IMPOSSIBLE");
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
}

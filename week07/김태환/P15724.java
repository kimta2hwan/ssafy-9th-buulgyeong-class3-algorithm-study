class P15724 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int M = read();
		int[][] map = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = map[i][j - 1] + map[i - 1][j] + read() - map[i - 1][j - 1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int K = read();
		
		while (K-- > 0) {
			int x1 = read() - 1;
			int y1 = read() - 1;
			int x2 = read();
			int y2 = read();
			
			sb.append(map[x2][y2] - map[x2][y1] - map[x1][y2] + map[x1][y1]).append('\n');
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
}

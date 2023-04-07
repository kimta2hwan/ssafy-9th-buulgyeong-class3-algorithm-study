class P2422 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int M = read();
		
		boolean[][] arr = new boolean[N + 1][N + 1];
		
		while (M-- > 0) {
			int a = read();
			int b = read();
			
			arr[a][b] = true;
			arr[b][a] = true;
		}
		
		int answer = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (arr[i][j]) {
					continue;
				}
				
				for (int k = j + 1; k <= N; k++) {
					if (arr[j][k] || arr[k][i]) {
						continue;
					}
					
					answer++;
				}
			}
		}
		
		System.out.print(answer);
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

class P2960 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int K = read();
		
		boolean[] visited = new boolean[N + 1];
		int count = 0;
		
		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j += i) {
				if (!visited[j]) {
					visited[j] = true;
					count++;
					
					if (count == K) {
						System.out.println(j);
						return;
					}
				}
			}
		}
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

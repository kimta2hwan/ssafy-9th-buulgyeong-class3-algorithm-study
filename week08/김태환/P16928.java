class P16928 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int M = read();
		
		int[] move = new int[101];
		
		for (int i = 1; i <= 100; i++) {
			move[i] = i;
		}
		
		while (N-- > 0) {
			move[read()] = read();
		}
		
		while (M-- > 0) {
			move[read()] = read();
		}
		
		int[] queue = new int[101];
		int[] checked = new int[101];
		int head = 0;
		int tail = -1;
		
		checked[1] = 1;
		queue[++tail] = 1;
		
		while (tail > head - 1) {
			int curr = queue[head++];
			
			for (int i = 1; i <= 6; i++) {
				int next = move[curr + i];
				
				if (checked[next] == 0) {
					checked[next] = checked[curr] + 1;
					
					if (next == 100) {
						System.out.print(checked[100] - 1);
						return;
					}
					
					queue[++tail] = next;
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

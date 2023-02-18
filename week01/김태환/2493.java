class P2493 {
	
	private static class Tower {
		int index;
		int height;
		int answer = 0;
		
		public Tower(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int N = read();
		Tower[] arr = new Tower[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = new Tower(i, read());
		}
		
		Tower[] stack = new Tower[N];
		int top = -1;
		
		for (int i = N - 1; i >= 0; i--) {
            while (top > -1 && stack[top].height < arr[i].height) {
				arr[stack[top--].index].answer = arr[i].index + 1;
			}
				
			stack[++top] = arr[i];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (Tower t : arr) {
			sb.append(t.answer).append(' ');
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

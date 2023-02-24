class P2847 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int[] stack = new int[N];
		int top = -1;
		
		while (N-- > 0) {
			stack[++top] = read();
		}
		
		int count = 0;
		
		while (top > 0) {
			int next = top - 1;
			
			while (stack[top] <= stack[next]) {
				stack[next]--;
				count++;
			}
			
			top--;
		}
		
		System.out.println(count);
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

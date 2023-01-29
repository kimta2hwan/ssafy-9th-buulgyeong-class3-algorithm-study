class P1874 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int n = read();
		
		int[] stack = new int[n];
		int top = -1;
		int num = 1;
		
		while (n-- > 0) {
			int input = read();
			
			while (true) {
				if (top > -1 && stack[top] == input) {
					sb.append('-').append('\n');
					top--;
					break;
				}
				
				if (top == stack.length - 1) {
					System.out.println("NO");
					return;
				}
				
				sb.append('+').append('\n');
				stack[++top] = num++;
			}
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

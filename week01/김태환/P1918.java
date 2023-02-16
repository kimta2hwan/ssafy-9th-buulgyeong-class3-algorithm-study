class P1918 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int[] stack = new int[100];
		int c, top = -1;
		
		while ((c = System.in.read()) > 32) {
			switch (c) {
				case 43: case 45: case 42: case 47:
					while (top > -1 && priority(stack[top]) >= priority(c)) {
						sb.append((char)stack[top--]);
					}
					
					stack[++top] = c;
					break;

				case 40:
					stack[++top] = c;
					break;
				
				case 41:
					while (top > -1 && stack[top] != 40) {
						sb.append((char)stack[top--]);
					}
					
					top--;
					break;
					
				default:
					sb.append((char)c);
			}
		}
		
		while (top > -1) {
			sb.append((char)stack[top--]);
		}
		
		System.out.println(sb);
	}
	
	private static int priority(int c) {
		if (c == 40 || c == 41) {
			return 0;
		}
		
		if (c == 43 || c == 45) {
			return 1;
		}
		
		if (c == 42 || c == 47) {
			return 2;
		}
		
		return -1;
	}
}

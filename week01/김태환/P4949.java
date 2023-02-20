class P4949 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int[] stack = new int[100];
		int c, top;
		
		while (true) {
			c = System.in.read();
			top = -1;
			
			if (c == 46) {
				break;
			}
			
			if (c == 40 || c == 41 || c == 91 || c == 93) {
				stack[++top] = c;
			}
			
			while ((c = System.in.read()) != 46) {
				switch (c) {
					case 40:
					case 91:
						stack[++top] = c;
						
						break;

					case 41:
						if (top > -1 && stack[top] == 40) {
							top--;
								
						} else {
							stack[++top] = c;
						}
							
						break;
							
					case 93:
						if (top > -1 && stack[top] == 91) {
							top--;
								
						} else {
							stack[++top] = c;
						}
							
						break;
				}
			}
			
			System.in.read();
            System.in.read();
			sb.append(top == -1 ? "yes" : "no").append('\n');
		}
		
		System.out.println(sb);
	}
}

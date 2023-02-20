class P3986 {
	public static void main(String[] args) throws Exception {
		int[] stack = new int[100000];
		int N = read();
		int count = 0;
		
		while (N-- > 0) {
			stack[0] = System.in.read();
			int c, top = 0;
			
			while ((c = System.in.read()) > 32) {
				if (top != -1) {
					if (c == 65) {
						if (stack[top] == 65) {
							top--;
							
						} else {
							stack[++top] = c;
						}
						
					} else {
						if (stack[top] == 66) {
							top--;
							
						} else {
							stack[++top] = c;
						}
					}
					
				} else {
					stack[++top] = c;
				}
			}
			
			if (top == -1) {
				count++;
			}
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

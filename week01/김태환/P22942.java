class P22942 {

    public static void main(String[] args) throws Exception {
    	int[] map = new int[2020001];
        int N = read();
        
        for (int i = 1; i <= N; i++) {
            int x = read();
            int r = read();
            
            map[x - r + 1010000] = i;
            map[x + r + 1010000] = -i;
        }

        int[] stack = new int[N + 1];
        int top = -1;
        
        for (int i : map) {
            if (i == 0) {
            	continue;
            }
            
            if (i > 0) {
                stack[++top] = i;
                
            } else {
                if (top == -1 || stack[top--] != -i) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println(top == -1 ? "YES" : "NO");
    }
    
    private static int read() throws Exception {
    	int c, n = System.in.read() & 15;
    	boolean isNegative = n == 13;
    	
    	if (isNegative) {
    		n = System.in.read() & 15;
    	}
    	
    	while ((c = System.in.read()) > 32) {
    		n = (n << 3) + (n << 1) + (c & 15);
    	}

        if (c == 13) {
            System.in.read();
        }
    	
    	return isNegative ? ~n + 1 : n;
    }
}

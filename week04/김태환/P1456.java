class Main {
    public static void main(String Args[]) throws Exception {
        boolean isNotPrime[] = new boolean[10000001];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i * i <= 10000001; i++) {
            if (isNotPrime[i]) {
            	continue;
            }
            
            for (int j = i + i; j < 10000001; j += i) {
            	isNotPrime[j] = true;
            }
        }
        
        long A = read();
        long B = read();
        int count = 0;
        
        for (int i = 2; i < 10000001; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            
            long temp = i;

            while ((double)temp <= (double)B / (double)i) {
                if ((double)temp >= (double)A / (double)i) {
                    count++;
                }
                
                temp *= i;
             }
        }
        
        System.out.println(count);
    }
    
    private static long read() throws Exception {
		long n = System.in.read() & 15;
		int c;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}

        if (c == 13) {
            System.in.read();
        }
		
		return n;
	}
}

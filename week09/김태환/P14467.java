class P14467 {
	public static void main(String[] args) throws Exception {
		int[] cow = new int[11];
		
		for (int i = 1; i <= 10; i++) {
			cow[i] = -1;
		}
		
		int N = read();
		int count = 0;
		
		while (N-- > 0) {
			int number = read();
			int input = read();
			
			if ((input == 0 && cow[number] == 1) || (input == 1 && cow[number] == 0)) {
				count++;
			}
			
			cow[number] = input;
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

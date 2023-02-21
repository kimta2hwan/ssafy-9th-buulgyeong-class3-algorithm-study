class P2217 {
	public static void main(String[] args) throws Exception {
		int[] rope = new int[10001];
		int N = read();
		
		while (N-- > 0) {
			rope[read()]++;
		}
		
		int sum = 0;
		int max = 0;
		int count = 0;
		
		for (int i = 10000; i > 0; i--) {
			if (rope[i] == 0) {
				continue;
			}
			
			count += rope[i];
			sum = i * count;
			max = calcMax(max, sum);
		}
		
		System.out.println(max);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
	
	private static int calcMax(int a, int b) {
		return a > b ? a : b;
	}
}

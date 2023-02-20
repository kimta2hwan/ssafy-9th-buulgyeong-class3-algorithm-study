class P10845 {
	public static void main(String[] args) throws Exception {
		int N = read();
		
		StringBuilder sb = new StringBuilder();
		int[] queue = new int[N];
		int head = 0;
		int tail = -1;
		
		while (N-- > 0) {
			int input = read();
			
			switch (input) {
				case 538:
					queue[++tail] = read();
					break;

				case 150:
					sb.append(tail > head - 1 ? queue[head++] : -1).append('\n');
					break;
					
				case 4005:
					sb.append(tail - head + 1).append('\n');
					break;

				case 63049:
					sb.append(tail == head - 1 ? 1 : 0).append('\n');
					break;
					
				case 63644:
					sb.append(tail > head - 1 ? queue[head] : -1).append('\n');
					break;

				case 2141:
					sb.append(tail > head - 1 ? queue[tail] : -1).append('\n');
					break;
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

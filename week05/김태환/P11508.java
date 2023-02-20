class P11508 {
	public static void main(String[] args) throws Exception {
		int[] arr = new int[100001];
		int N = read();
		int sum = 0;
		
		while (N-- > 0) {
			int price = read();
			arr[price]++;
			sum += price;
		}
		
		int count = 0;
		
		for (int i = 100000; i >= 0; i--) {
			if (arr[i] == 0) {
				continue;
			}
			
			while (arr[i]-- > 0) {
				count++;
				
				if (count == 3) {
					sum -= i;
					count = 0;
				}
			}
		}
		
		System.out.println(sum);
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

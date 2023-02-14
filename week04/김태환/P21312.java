class P21312 {
	public static void main(String[] args) throws Exception {
		int value1 = 1;
		int value2 = 1;
		boolean odd = false;
		
		int[] arr = new int[3];
		
		for (int i = 0; i < 3; i++) {
			arr[i] = read();
			
			if (arr[i] % 2 == 1) {
				value1 *= arr[i];
				odd = true;
				
			} else {
				value2 *= arr[i];
			}
		}
		
		if (odd) {
			System.out.println(value1);
			
		} else {
			System.out.println(value2);
		}
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

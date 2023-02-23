class P1439 {
	public static void main(String[] args) throws Exception {
		byte[] buffer = new byte[1000000];
		System.in.read(buffer);
		
		int[] count = new int[2];
		int flag = 0;
		byte prior = buffer[0];
		
		count[flag]++;
		
		for (int i = 1; i < 1000000; i++) {
			if (buffer[i] != 48 && buffer[i] != 49) {
				break;
			}
			
			if (buffer[i] == prior) {
				continue;
			}
			
			prior = buffer[i];
			flag ^= 1;
			count[flag]++;
		}
		
		System.out.println(count[0] < count[1] ? count[0] : count[1]);
	}
}

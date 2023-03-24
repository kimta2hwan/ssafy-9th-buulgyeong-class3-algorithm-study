class P5597 {
	public static void main(String[] args) throws Exception {
        boolean[] student = new boolean[31];

        for (int i = 0; i < 28; i++) {
            student[read()] = true;
        }
        
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 31; i++) {
            if (student[i]) {
            	continue;
            }
            
            sb.append(i).append('\n');
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

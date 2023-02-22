import java.util.Arrays;

class P1931 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int[][] meeting = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			meeting[i][0] = read();
			meeting[i][1] = read();
		}
		
		Arrays.sort(meeting, (m1, m2) -> m1[1] == m2[1] ? m1[0] - m2[0] : m1[1] - m2[1]);
		
		int endTime = 0;
		int count = 0;
		
		for (int[] m : meeting) {
			if (m[0] >= endTime) {
				endTime = m[1];
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

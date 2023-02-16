import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P21275 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String A = st.nextToken();
		String B = st.nextToken();
		int count = 0;
		
		for (int i = 2; i <= 36; i++) {
			for (int j = 2; j <= 36; j++) {
				if (i == j) {
					continue;
				}
				
				long a = 0;
				long b = 0;
				
				try {
					a = Long.parseLong(A, i);
				} catch (Exception e) {
					continue;
				}
				
				try {
					b = Long.parseLong(B, j);
				} catch (Exception e) {
					continue;
				}
				
				if (a != b) {
					continue;
				}
				
				count++;
				
				if (count == 1) {
					sb.append(a).append(' ').append(i).append(' ').append(j);
				}
			}
		}
		
		if (count == 0) {
			System.out.println("Impossible");
			
		} else if (count > 1) {
			System.out.println("Multiple");
			
		} else {
			System.out.println(sb);
		}
	}
}

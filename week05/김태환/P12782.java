import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P12782 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			char[] a = st.nextToken().toCharArray();
			char[] b = st.nextToken().toCharArray();
			
			int countA = 0;
			int countB = 0;
			
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					if (a[i] == '1') {
						countA++;
						
					} else {
						countB++;
					}
				}
			}
			
			sb.append(countA > countB ? countA : countB).append('\n');
		}
		
		System.out.println(sb);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class P9375 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			Map<String, Integer> map = new HashMap<>(n);
			int answer = 1;
			
			while (n-- > 0) {
				st = new StringTokenizer(br.readLine());
				
				st.nextToken();
				String kind = st.nextToken();
				
				map.put(kind, map.getOrDefault(kind, 0) + 1);
			}
			
			for (int value : map.values()) {
				answer *= (value + 1);
			}
			
			sb.append(--answer).append('\n');
		}
		
		System.out.println(sb);
	}
}

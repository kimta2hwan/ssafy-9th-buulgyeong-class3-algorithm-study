import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class P1620 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> nameKeyMap = new HashMap<>();
		String[] numberKeyMap = new String[N + 1];
		
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			
			nameKeyMap.put(name, i);
			numberKeyMap[i] = name;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (M-- > 0) {
			String input = br.readLine();
			sb.append(input.charAt(0) < 58 ? numberKeyMap[Integer.parseInt(input)] : nameKeyMap.get(input)).append('\n');
		}
		
		System.out.println(sb);
	}
}

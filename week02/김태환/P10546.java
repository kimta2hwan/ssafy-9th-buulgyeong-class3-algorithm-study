import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class P10546 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0) + 1);
		}
		
		while (N-- > 1) {
			String name = br.readLine();
			map.put(name, map.get(name) - 1);
		}
		
		for (String name : map.keySet()) {
			if (map.get(name) == 1) {
				System.out.println(name);
				break;
			}
		}
	}
}

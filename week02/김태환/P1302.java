import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new TreeMap<>();
		
		while (N-- > 0) {
			String book = br.readLine();
			map.put(book, map.getOrDefault(book, 0) + 1);
		}
		
		String answer = "";
		int max = 0;
		
		for (String book : map.keySet()) {
			int count = map.get(book);
			
			if (count > max) {
				answer = book;
				max = count;
			}
		}
		
		System.out.println(answer);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class P14425 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> S = new HashSet<>();
		int answer = 0;
		
		while (N-- > 0) {
			S.add(br.readLine());
		}
		
		while (M-- > 0) {
			if (S.contains(br.readLine())) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}

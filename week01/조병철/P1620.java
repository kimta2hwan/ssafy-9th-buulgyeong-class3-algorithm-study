import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class P1620 {
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<>();
		for (int i = 1; i <= N; ++i) {
			String s = br.readLine();
			map.put(Integer.toString(i), s);
			map.put(s,Integer.toString(i));

		}

		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
				sb.append(map.get(br.readLine())).append('\n');
		}
		System.out.println(sb);
	}
}

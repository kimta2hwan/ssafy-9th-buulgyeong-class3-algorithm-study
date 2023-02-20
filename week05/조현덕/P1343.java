import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1343 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		int Xcount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'X') {
				Xcount++;
			} else if (s.charAt(i) == '.') {
				if (Xcount == 2) {
					sb.append("BB");
					Xcount = 0;
				} else if (Xcount > 0) {
					sb.setLength(0);
					sb.append(-1);
					break;
				}
				sb.append(".");
			}
			if (Xcount == 4) {
				sb.append("AAAA");
				Xcount = 0;
			}
		}
		if (Xcount == 2) {
			sb.append("BB");
		} else if (Xcount > 0) {
			sb.setLength(0);
			sb.append(-1);
		}

		System.out.println(sb);

	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9012 {

	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();

			if (s.length() % 2 == 1 || s.charAt(s.length() - 1) == '(' || s.charAt(0) == ')') {
				System.out.println("NO");
				continue;
			}

			int left = 0;
			boolean flag = true;
			for (int i = 0; i < s.length(); ++i) {
				if (s.charAt(i) == '(')
					++left;
				else {
					if (left > 0)
						--left;
					else {
//						System.out.println("NO");
						flag = false;
						break;
					}
				}
			}
			if (flag && left == 0) {
				System.out.println("YES");

			} else
				System.out.println("NO");

		}

	}

}

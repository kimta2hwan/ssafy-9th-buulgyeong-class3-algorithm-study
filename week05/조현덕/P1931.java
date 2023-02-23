import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P1931 {

	static int N;
	static List<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		Collections.sort(list, (n1, n2) -> n1[1] == n2[1] ? n1[0] - n2[0] : n1[1] - n2[1]);

		int result = 0;
		int end = 0;
		for (int[] l : list) {
			if (end <= l[0]) {
				result++;
				end = l[1];
			}
		}

		System.out.println(result);
	}

}

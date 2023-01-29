import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 요세푸스 문제
public class P1158 {
	static int[] arr;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; ++i)
			arr[i] = i + 1;

		int chk = 0;
		int cnt = 1;
		int cur = 0;

		sb.append('<');
		while (chk < N) {

			if (cnt == K && arr[cur] != 0) {
				++chk;
				cnt = 1;
				sb.append(arr[cur] + ", ");
				arr[cur] = 0;
			} else if (arr[cur] != 0) {
				++cnt;
				++cur;
				if (cur >= N)
					cur %= N;
			} else {
				++cur;
				if (cur >= N)
					cur %= N;
			}
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append('>');
// 1 2 3 4 5 6 7
		System.out.println(sb);
	}

}

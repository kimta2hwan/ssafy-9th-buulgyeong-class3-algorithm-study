import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305 {

	static int N, K;
	static long[] length, price;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		length = new long[N - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			length[i] = Integer.parseInt(st.nextToken());
		}
		price = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		// price를 내림차순으로 맞춰 준다
		// 8 9 3 4 2 1 => 8 8 3 3 2 1

		int i = 1;
		while (i < N) {
			if (price[i - 1] < price[i]) {
				price[i] = price[i - 1];
			}
			i++;
		}

		long sum = 0;
		for (i = 0; i < N - 1; i++) {
			sum += price[i] * length[i];
		}

		System.out.println(sum);
	}

}

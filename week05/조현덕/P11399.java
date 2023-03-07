import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11399 {

	static int N;
	static int[] input, sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		sum = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);
		sum[0] = input[0];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + input[i];
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			result += sum[i];
		}

		System.out.println(result);
	}

}

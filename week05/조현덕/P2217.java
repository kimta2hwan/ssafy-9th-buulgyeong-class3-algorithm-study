import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2217 {

	static int N;
	static int[] rope;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		rope = new int[N];
		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(rope);

		int max = rope[0] * N;
		for (int i = 1; i < N; i++) {
			max = Math.max(max, rope[i] * (N - i));
		}
		
		System.out.println(max);
	}
}

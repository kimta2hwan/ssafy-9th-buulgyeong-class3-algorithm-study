import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14916 {
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = n / 5; i >= 0; i--) {
			count = i;
			int temp = n - i * 5;
			if (temp % 2 == 0) {
				min = count + temp / 2;
				break;
			}
		}
		if (min == 0) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}
}

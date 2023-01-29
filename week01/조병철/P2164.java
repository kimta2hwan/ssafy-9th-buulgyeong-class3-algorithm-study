import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P2164 {
	static int N;
	static ArrayList<Integer> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; ++i)
			arr.add(i);
		while (arr.size() > 1) {
			ArrayList<Integer> tmp = new ArrayList<>();

			if (arr.size() % 2 == 0) {
				for (int i = 1; i < arr.size(); i += 2) {
					tmp.add(arr.get(i));
				}
			} else {
				tmp.add(arr.get(arr.size() - 1));
				for (int i = 1; i < arr.size(); i += 2) {
					tmp.add(arr.get(i));
				}
			}

			arr = tmp;
		}

		System.out.println(arr.get(0));

	}
}

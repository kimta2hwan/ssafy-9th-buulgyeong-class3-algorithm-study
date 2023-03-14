import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P12865 {

	static int N, K;
	static int[][] things;
	static int[][] memoi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		things = new int[N + 1][2];
		memoi = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = Integer.parseInt(st.nextToken());
			things[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(things, (t1, t2) -> t1[0] - t2[0]);

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j - things[i][0] >= 0) {
					memoi[i][j] = Math.max(memoi[i - 1][j], memoi[i - 1][j - things[i][0]] + things[i][1]);
				} else {
					memoi[i][j] = memoi[i - 1][j];
				}

			}
		}

		System.out.println(memoi[N][K]);
	}

}

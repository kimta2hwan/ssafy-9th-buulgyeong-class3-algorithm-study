import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1520 {

	static int M, N;
	static int[][] map, memoi;
	static boolean[][] isVisited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		memoi = new int[M][N];
		isVisited = new boolean[M][N];
		int ans = dfs(0, 0);
		System.out.println(ans);
	}

	static int dfs(int y, int x) {
		if (y == M - 1 && x == N - 1) {
			return 1;
		}

		if (isVisited[y][x]) {
			return memoi[y][x];
		}

		isVisited[y][x] = true;
		int way = 0;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= M || nx >= N || map[ny][nx] >= map[y][x]) {
				continue;
			}
			
			way += dfs(ny, nx);
		}

		memoi[y][x] = way;

		return memoi[y][x];
	}
}

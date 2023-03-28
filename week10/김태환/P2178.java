class P2178 {

    static int[][] maze;
    static boolean[][] visited;
    static int N, M;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maze[i][j] = System.in.read();
            }

            System.in.read();
        }

        bfs();
        System.out.println(maze[N - 1][M - 1]);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }

    private static void bfs() {
        int[][] queue = new int[N * M][2];
        int head = 0;
        int tail = -1;

        queue[++tail] = new int[]{0, 0};
        maze[0][0] = 1;
        visited[0][0] = true;

        while (tail > head - 1) {
            int r = queue[head][0];
            int c = queue[head++][1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || maze[nr][nc] == 48) {
                    continue;
                }

                queue[++tail] = new int[]{nr, nc};
                maze[nr][nc] = maze[r][c] + 1;
                visited[nr][nc] = true;
            }
        }
    }
}

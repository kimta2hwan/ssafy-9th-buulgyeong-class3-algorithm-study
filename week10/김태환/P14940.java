class P14940 {

    private static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static boolean[][] visited;
    private static int[][] map;
    private static int n, m;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        map = new int[n][m];

        int sr = 0;
        int sc = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = read();

                if (map[i][j] == 2) {
                    sr = i;
                    sc = j;
                }
            }
        }

        bfs(sr, sc);
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    sb.append(-1);

                } else {
                    sb.append(map[i][j]);
                }

                sb.append(' ');
            }

            sb.append('\n');
        }

        System.out.print(sb);
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

    private static void bfs(int sr, int sc) {
        Point[] queue = new Point[n * m];
        visited = new boolean[n][m];
        int head = 0;
        int tail = -1;

        map[sr][sc] = 0;
        queue[++tail] = new Point(sr, sc);
        visited[sr][sc] = true;

        while (tail > head - 1) {
            Point curr = queue[head++];

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }

                map[nr][nc] = map[curr.r][curr.c] + 1;
                queue[++tail] = new Point(nr, nc);
                visited[nr][nc] = true;
            }
        }
    }
}

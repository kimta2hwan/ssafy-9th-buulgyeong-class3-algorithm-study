import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P19236 {

    static class Fish implements Cloneable {
        int id, r, c, d;
        boolean dead;

        Fish(int id, int r, int c, int d) {
            this.id = id;
            this.r = r;
            this.c = c;
            this.d = d;
        }

        @Override
        public Fish clone() {
            try {
                return (Fish) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    static Fish[] initFishes = new Fish[17];
    static int[][] initGrid = new int[4][4];
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
    static int answer;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken()) - 1;
                initFishes[a] = new Fish(a, i, j, b);
                initGrid[i][j] = a;
            }
        }
    }

    static void solve() {
        int firstPreyId = initGrid[0][0];
        Fish firstPrey = initFishes[firstPreyId];
        firstPrey.dead = true;
        dfs(firstPreyId, 0, 0, firstPrey.d, initGrid, initFishes);

        System.out.println(answer);
    }

    static void dfs(int eatSum, int sr, int sc, int d, int[][] grid, Fish[] fishes) {
        answer = Math.max(answer, eatSum);

        grid[sr][sc] = -1;
        moveFish(grid, fishes);
        grid[sr][sc] = 0;
        while (true) {
            sr += dr[d];
            sc += dc[d];
            if (sr < 0 || sr >= 4 || sc < 0 || sc >= 4) break;
            if (grid[sr][sc] == 0) continue;

            int[][] nextGrid = new int[4][4];
            for (int i = 0; i < 4; i++) {
                System.arraycopy(grid[i], 0, nextGrid[i], 0, 4);
            }
            Fish[] nextFishes = new Fish[17];
            for (int i = 1; i <= 16; i++) {
                nextFishes[i] = fishes[i].clone();
            }

            int preyId = nextGrid[sr][sc];
            Fish prey = nextFishes[preyId];
            prey.dead = true;
            dfs(eatSum + preyId, sr, sc, prey.d, nextGrid, nextFishes);
        }
    }

    static void moveFish(int[][] grid, Fish[] fishes) {
        for (int i = 1; i <= 16; i++) {
            Fish cur = fishes[i];
            if (cur.dead) continue;
            int r = cur.r;
            int c = cur.c;
            for (int t = 0; t < 8; t++, cur.d = (cur.d + 1) % 8) {
                int nr = r + dr[cur.d];
                int nc = c + dc[cur.d];
                if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue;
                if (grid[nr][nc] == -1) continue;
                int thereId = grid[nr][nc];
                grid[nr][nc] = cur.id;
                grid[cur.r][cur.c] = thereId;
                cur.r = nr;
                cur.c = nc;
                if (thereId != 0) {
                    Fish there = fishes[thereId];
                    there.r = r;
                    there.c = c;
                }
                break;
            }
        }
    }
}
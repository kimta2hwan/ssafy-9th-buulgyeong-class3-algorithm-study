import java.util.*;
import java.io.*;

public class P21611 {

    static class Magic {
        int d, s;

        Magic(int d, int s) {
            this.d = d;
            this.s = s;
        }
    }

    static class Seq {
        int num, cnt;

        Seq(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    static int N, M, mid;
    static int[][] grid;
    static Magic[] magics;
    static int[] bombCount = new int[4];
    static int[] dy = {0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] ry = {0, 1, 0, -1};
    static int[] rx = {-1, 0, 1, 0};
    static int[] rArr;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        magics = new Magic[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            magics[i] = new Magic(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    static void solve() {
        mid = N / 2;
        rArr = new int[2 * N - 1];
        for (int i = 0; i < rArr.length; i++) {
            rArr[i] = (i + 2) / 2;
        }
        rArr[rArr.length - 1]--;

        for (Magic cur : magics) {
            blizzard(cur.d, cur.s);
            bomb();
            change();
        }

        int answer = 0;
        for (int i = 1; i <= 3; i++) {
            answer += i * bombCount[i];
        }
        System.out.println(answer);
    }

    static void blizzard(int d, int s) {
        for (int i = 1; i <= s; i++) {
            grid[mid + i * dy[d]][mid + i * dx[d]] = 0;
        }
    }

    static void bomb() {
        ArrayDeque<Seq> dq = new ArrayDeque<>();
        int y = mid;
        int x = mid;
        int d = 0;
        for (int r : rArr) {
            for (int i = 0; i < r; i++) {
                y += ry[d];
                x += rx[d];
                if (grid[y][x] == 0) continue;
                if (!dq.isEmpty() && grid[y][x] == dq.peekLast().num) {
                    dq.peekLast().cnt++;
                } else {
                    dq.offerLast(new Seq(grid[y][x], 1));
                }
            }
            d = (d + 1) % 4;
        }
        if (dq.isEmpty()) return;

        boolean flag = true;
        while (flag && !dq.isEmpty()) {
            int prevNum = dq.peekFirst().num;
            int prevCnt = dq.pollFirst().cnt;
            flag = false;
            int sz = dq.size();
            for (int i = 0; i < sz; i++) {
                int curNum = dq.peekFirst().num;
                int curCnt = dq.pollFirst().cnt;
                if (curNum == prevNum) prevCnt += curCnt;
                else {
                    if (prevCnt >= 4) {
                        bombCount[prevNum] += prevCnt;
                        flag = true;
                    }
                    else dq.offerLast(new Seq(prevNum, prevCnt));
                    prevNum = curNum;
                    prevCnt = curCnt;
                }
            }
            if (prevCnt >= 4) {
                bombCount[prevNum] += prevCnt;
                flag = true;
            } else {
                dq.offerLast(new Seq(prevNum, prevCnt));
            }
        }

        y = x = mid;
        d = 0;
        for (int r : rArr) {
            for (int i = 0; i < r; i++) {
                y += ry[d];
                x += rx[d];
                if (dq.isEmpty()) grid[y][x] = 0;
                else {
                    grid[y][x] = dq.peekFirst().num;
                    if (--dq.peekFirst().cnt == 0) dq.pollFirst();
                }
            }
            d = (d + 1) % 4;
        }
    }

    static void change() {
        Queue<Integer> q = new ArrayDeque<>();
        int y = mid;
        int x = mid;
        int prevNum = 0;
        int prevCnt = 0;
        int d = 0;
        for (int r : rArr) {
            for (int i = 0; i < r; i++) {
                y += ry[d];
                x += rx[d];
                if (grid[y][x] == 0) continue;
                if (grid[y][x] == prevNum) {
                    prevCnt++;
                } else {
                    if (prevNum != 0) {
                        q.offer(prevCnt);
                        q.offer(prevNum);
                    }
                    prevCnt = 1;
                    prevNum = grid[y][x];
                }
            }
            d = (d + 1) % 4;
        }
        if (prevNum != 0) {
            q.offer(prevCnt);
            q.offer(prevNum);
        }

        y = x = mid;
        d = 0;
        for (int r : rArr) {
            for (int i = 0; i < r; i++) {
                y += ry[d];
                x += rx[d];
                if (q.isEmpty()) grid[y][x] = 0;
                else grid[y][x] = q.poll();
            }
            d = (d + 1) % 4;
        }
    }
}

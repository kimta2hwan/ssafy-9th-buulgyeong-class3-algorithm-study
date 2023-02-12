import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1. 현민이는 '가장 깊은 자식 리프 노드로부터의 거리가 D인 노드'를 모두 방문하고 돌아와야 최적이다
 * 2. 각 노드마다 '가장 깊은 자식 리프 노드로부터의 거리'를 저장해 놓자
 * 3. 각 노드를 방문할 때 저장해 놓은 거리가 D 미만이면 이동하지 않은 것으로 간주하고 돌아간다
 */
public class P19542 {
    static int N, S, D;
    static ArrayList<Integer>[] tree;
    static int[] leafDist;
    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }
    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }
        br.close();
    }
    static void solve() {
        leafDist = new int[N + 1];
        calcDist(S, 0);
        System.out.println(delivery(S, 0));
    }
    static int calcDist(int cur, int par) {
        int curDist = 0;
        for (int nex : tree[cur]) {
            if (nex != par) {
                curDist = Math.max(curDist, 1 + calcDist(nex, cur)); // try 1) WA. curDist 최댓값 갱신 오류 수정
            }
        }
        return leafDist[cur] = curDist;
    }
    static int delivery(int cur, int par) {
        int totalDist = 0;
        for (int nex : tree[cur]) {
            if (nex != par) {
                if (leafDist[nex] < D) continue;
                totalDist += 2 + delivery(nex, cur);
            }
        }
        return totalDist;
    }
}

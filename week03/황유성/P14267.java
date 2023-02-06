import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 부모 배열로부터 트리를 만들어야 효율적인 풀이가 가능하다.
 * 2. 트리의 루트에서부터 재귀 호출을 통해 dfs하면서 마주치는 칭찬을 모두 처리하자.
 * 2. 각 노드를 방문할 때에만 lazy하게 칭찬이 반영되는 셈이다.
 * 3. 따라서 O(N)의 시간 복잡도로 칭찬 수치를 반영하고 계산할 수 있다.
 */

public class P14267 {
    static int n, m;
    static int[] parents, scores;
    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        readInput();
        solve();
        writeOutput();
    }
    static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        scores = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            scores[idx] += weight;
        }
        br.close();
    }
    static void solve(){
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 2; i <= n; i++) {
            tree[parents[i]].add(i);
        }
        dfs(1);
    }
    static void dfs(int node) {
        for (int child : tree[node]) {
            scores[child] += scores[node];
            dfs(child);
        }
    }

    static void writeOutput() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            bw.write(scores[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}

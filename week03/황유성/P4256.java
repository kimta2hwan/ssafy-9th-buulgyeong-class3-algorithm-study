import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ex1)
 *  3 2 1 4 [pre]
 *
 *  2 3 4 1 [in]
 *
 *    1
 *  2     3
 *      4
 *
 *
 * ex2)
 * 3 6 5 4 8 7 1 2 [pre]
 *
 * 5 6 8 4 3 1 2 7 [in]
 *
 *         1
 *   2           6
 * 3         7
 *       4     8
 *     5
 *
 *
 * myEx)
 *
 *      1
 *   2     3
 * 4   5 6   7
 *
 * 1 2 4 5 3 6 7 [pre]
 *
 * 4 2 5 1 6 3 7 [in]
 *
 *       1
 *   2       5
 * 3   4   6   7
 *
 *
 * 1. 노드 번호별 전위 순회 방문 순서를 저장해 놓는다
 * 2. 중위 순회 방문 순서에서 우선 루트 노드를 찾는다.
 * 3. 루트 노드를 재귀 호출의 시작점으로 삼는다.
 * 4. 재귀 호출은 (* 다음 번호: 전위 순회 방문 순서에서 다음 번호)
 * 4.1) 매개변수의 노드를 기준으로 왼쪽에서 다음 번호를 찾아서 왼쪽 자식으로 삼고, 해당 노드에서 매개변수로 하여 재귀 호출을 한다
 * 4.2) 매개변수의 노드를 기준으로 오른쪽에서 ...
 * 5. 이러면 트리가 완성되고 후위 순회를 하면 된다
 * 6. 시간 복잡도는 테케 하나당 O(N^2)
 * 7. 왼쪽, 오른쪽을 나눠 재귀 호출을 하는 이유는 탐색한 노드가 어느 부모의 어느쪽 자식인지 식별하기 위해.
 */
public class P4256 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, cnt;
    static int[] preOrder = new int[1000];
    static int[] inOrder = new int[1000];
    static int[] preCheck = new int[1001];
    static int[] left;
    static int[] right;
    static StringBuilder answer;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            readTestCase();
            init();
            solve();
        }
    }

    static void readTestCase() throws Exception {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            preOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void init() {
        cnt = 1;
        left = new int[n + 1];
        right = new int[n + 1];
        answer = new StringBuilder();
    }
    static void solve() {
        for (int i = 0; i < n; i++) {
            preCheck[preOrder[i]] = i;
        }
        int root = preOrder[0];
        int rootIdx = -1;
        for (int i = 0; i < n; i++) {
            if (inOrder[i] == root) {
                rootIdx = i;
                break;
            }
        }
        left[root] = findChild(0, rootIdx - 1);
        right[root] = findChild(rootIdx + 1, n - 1);

        postOrder(root);
        System.out.println(answer);
    }
    static int findChild(int l, int r) {
        int child = 0, childIdx = -1;
        for (int i = l; i <= r; i++) {
            if (preCheck[inOrder[i]] == cnt) {
                cnt++;
                child = inOrder[i];
                childIdx = i;
                break;
            }
        }
        if (childIdx == -1) return 0;
        left[child] = findChild(l, childIdx - 1);
        right[child] = findChild(childIdx + 1, r);
        return child;
    }

    static void postOrder(int node) {
        if (left[node] != 0) postOrder(left[node]);
        if (right[node] != 0) postOrder(right[node]);
        answer.append(node).append(' ');
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 1 2 3 (in)
 1 3 2 (post)

   2
 1   3


      1
    2    5
  3  4 6  7

 3 2 4 1 6 5 7 (in)
 3 4 2 6 7 5 1 (post)

       1
    5     2
  7   6 4   3

 7 5 6 1 4 2 3 (in)
 1 5 7 6 2 4 3 (pre)
 7 6 5 4 3 2 1 (post)

 1. inOrder, postOrder를 좌우 반전 시키면
        좌우 반전된 트리의 inOrder, preOrder가 된다
 2. [P4256]에서와 같이, 좌우 반전 트리의 postOrder를 구한다
 3. 구한 postOrder를 좌우 반전시키면 주어진 트리의 preOrder가 된다
 4. 단 [P4256]과 다르게 N의 크기가 커서 시간 복잡도 O(N^2)로는 풀이가 안 된다
 5. 좌우 반전 트리의 inOrder 값마다 해당하는 노드의 번호를 저장해 놓으면 O(N)으로 풀이 가능하다
 */

public class P2263 {
    static int n, cnt = 1, idx = 0;
    static int[] inOrder, postOrder, revInOrder, revPreOrder, revPostOrder;
    static int[] inCheck, left, right;
    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }
    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
    }
    static void solve() {
        revInOrder = new int[n];
        revPreOrder = new int[n];
        for (int i = 0; i < n; i++) {
            revInOrder[i] = inOrder[n - 1 - i];
            revPreOrder[i] = postOrder[n - 1 - i];
        }

        inCheck = new int[n + 1];
        for (int i = 0; i < n; i++) {
            inCheck[revInOrder[i]] = i;
        }

        left = new int[n + 1];
        right = new int[n + 1];
        int revRoot = revPreOrder[0];
        int rootIdx = inCheck[revRoot];
        left[revRoot] = findChild(0, rootIdx - 1);
        right[revRoot] = findChild(rootIdx + 1, n - 1);

        revPostOrder = new int[n];
        postOrderTraversal(revRoot);

        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(revPostOrder[i]).append(' ');
        }
        System.out.println(sb);
    }
    static int findChild(int l, int r) {
        if (cnt == n) {
            return 0;
        }
        int child = revPreOrder[cnt];
        int childIdx = inCheck[child];
        if (l <= childIdx && childIdx <= r) {
            cnt++;
            left[child] = findChild(l, childIdx - 1);
            right[child] = findChild(childIdx + 1, r);
            return child;
        }
        return 0;
    }
    static void postOrderTraversal(int node) {
        if (left[node] != 0) postOrderTraversal(left[node]);
        if (right[node] != 0) postOrderTraversal(right[node]);
        revPostOrder[idx++] = node;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 입력에 주어지는 노드를 순서대로 큐에 담는다 -> 큐에 안 담고 인덱스를 움직이면 더 효율적이다
 * 2. 이때 연속하는 노드들을
 *  2.1) 큐의 맨앞의 원소의 자식으로 삼고
 *  2.2) 자식의 부모를 배열에 기록해 놓는다
 * 3. k의 조부모에 대해 (모든 자식들의 자식 수 - k의 부모의 자식 수)를 구한다
 * 4. 노드의 번호가 아니라 노드의 인덱스를 통해 자료구조를 관리하는 것이 효율적이다
 */
public class P9489 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n, k;
    static int[] nodeArr = new int[1000];
    static int[] parent = new int[1000];
    static ArrayList<Integer>[] tree = new ArrayList[1_000];
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nodeArr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++) {
                tree[i].clear();    // try 1) WA. 현재 테스트 케이스에서 리프 노드들의 자식 노드 정보는 초기화되지 않던 오류 수정
            }
            solve();
        }
        System.out.println(sb);
    }
    static void solve() {
        int par = -1;
        int prevVal = -1;
        for (int chl = 1; chl < n; chl++) {
            int curVal = nodeArr[chl];
            if (curVal != prevVal + 1) {
                par++;
            }
            tree[par].add(chl);
            parent[chl] = par;
            prevVal = curVal;
        }
        int kNode = Arrays.binarySearch(nodeArr, 0, n, k);
        int pa = parent[kNode];
        if (pa == 0) {
            sb.append("0\n");
            return;
        }
        int grandpa = parent[pa];
        int answer = -tree[pa].size();
        for (int chl : tree[grandpa]) {
            answer += tree[chl].size();
        }
        sb.append(answer).append('\n');
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1. 같은 트리에 속한 임의의 두 노드는 반드시 공통 조상 노드를 가진다.
 * 2. 두 노드 각각의 최소 공통 조상까지의 거리를 합하면 두 노드 사이의 거리와 같다.
 * 3. 트리의 루트 노드가 무엇이든 간에 모든 노드 간의 거리 정보는 고정되어 있으므로, 1번 노드를 루트로 삼자.
 * 4. 시간 복잡도 O(NM)으로 풀이 가능하다.
 */
public class P1240 {
    static final int ROOT = 1;
    static int N, M;
    static ArrayList<Pair>[] graph;
    static Pair[] parent;
    static int[] depth;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[nodeA].add(new Pair(nodeB, weight));
            graph[nodeB].add(new Pair(nodeA, weight));
        }
        
        parent = new Pair[N + 1];
        depth = new int[N + 1];
        dfs(ROOT, 0);
        
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            
            answer.append(dist(nodeA, nodeB)).append('\n');
        }
        System.out.print(answer);
    }
    
    static void dfs(int curNode, int parNode) {
        for (Pair p : graph[curNode]) {
            if (p.nextNode == parNode) continue;
            parent[p.nextNode] = new Pair(curNode, p.weight);
            depth[p.nextNode] = depth[curNode] + 1;
            dfs(p.nextNode, curNode);
        }
    }

    static int dist(int a, int b) {
        int ret = 0;
        if (depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int depthA = depth[a];
        while (depthA < depth[b]) {
            ret += parent[b].weight;
            b = parent[b].nextNode;
        }
        while (a != b) {
            ret += parent[a].weight;
            a = parent[a].nextNode;
            ret += parent[b].weight;
            b = parent[b].nextNode;
        }
        return ret;
    }

    static class Pair {
        int nextNode;
        int weight;

        Pair(int nextNode, int weight) {
            this.nextNode = nextNode;
            this.weight = weight;
        }
    }
}

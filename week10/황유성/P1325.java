import java.util.*;
import java.io.*;

public class P1325 {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static ArrayDeque<Integer> q = new ArrayDeque<>(10000);
    static int[] visitCnt, visitTurn;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
    }

    static void solve() {
        visitCnt = new int[N + 1];
        visitTurn = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        int maxCnt = 0;
        for (int i = 1; i <= N; i++) {
            maxCnt = Math.max(maxCnt, visitCnt[i]);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (visitCnt[i] == maxCnt)
                answer.append(i).append(' ');
        }
        System.out.println(answer);
    }

    static void bfs(int start) {
        q.offerLast(start);
        visitTurn[start] = start;
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            visitCnt[cur]++;
            for (int nex : graph[cur]) {
                if (visitTurn[nex] != start) {
                    q.offerLast(nex);
                    visitTurn[nex] = start;
                }
            }
        }
    }
}

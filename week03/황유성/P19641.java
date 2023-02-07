import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 오일러 경로 테크닉을 구현한다
 */
public class P19641 {
    static int N, S, cnt;
    static int[] left, right;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        readInput();
        solve();
        writeOutput();
    }

    static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB;
            while ((nodeB = Integer.parseInt(st.nextToken())) != -1) {
                graph[nodeA].add(nodeB);
            }
        }
        S = Integer.parseInt(br.readLine());
        br.close();
    }

    static void solve() {
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        left = new int[N + 1];
        right = new int[N + 1];
        eulerTrack(S, 0);
    }

    static void eulerTrack(int current, int parent) {
        left[current] = ++cnt;
        for (int child : graph[current]) {
            if (child != parent)
                eulerTrack(child, current);
        }
        right[current] = ++cnt;
    }

    static void writeOutput() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(i).append(' ').append(left[i]).append(' ').append(right[i]).append('\n');
        }
        System.out.println(sb);
    }
}
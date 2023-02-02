import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * O(TM) 풀이가 있다면 깔끔할 텐데, 그런 풀이가 떠오르지 않는다
 * O(TMlogM) 풀이로는 최소/최대 우선순위 큐 하나씩 만들어서 사용할 수 있다
 * 1. minPQ의 모든 원소들은 maxPQ의 모든 원소들보다 작지 않도록 유지한다
 * 2. 또한 minPQ의 크기는 maxPQ의 크기와 같거나 1만큼 크도록 유지한다
 * 3. 홀수 차례마다 minPQ에서 원소 하나를 peek하면 그것이 중앙값이다
 */

public class P2696 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int M;
    static int[] arr = new int[10000];
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            readInput();
            solve();
        }
        bw.flush();
        bw.close();
    }
    static void readInput() throws IOException {
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= M / 10; i++) {
            sb.append(br.readLine());
            sb.append(" ");
        }
        StringTokenizer st = new StringTokenizer(sb.toString());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    static void solve() throws IOException {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        StringBuilder sb = new StringBuilder();
        int numCnt = 0;
        for (int i = 0; i < M; i++) {
            maxPQ.offer(arr[i]);
            while (!maxPQ.isEmpty() && !minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
                minPQ.offer(maxPQ.poll());
                maxPQ.offer(minPQ.poll());
            }
            if (i % 2 == 1) continue;
            if (maxPQ.size() == minPQ.size() + 1) {
                minPQ.offer(maxPQ.poll());
            }
            if (numCnt == 10) {
                numCnt = 0;
                sb.append("\n");
            }
            sb.append(minPQ.peek());
            sb.append(" ");
            numCnt++;
        }
        bw.write((M / 2 + 1) + "\n");
        bw.write(sb.toString());
        bw.write("\n");
    }
}

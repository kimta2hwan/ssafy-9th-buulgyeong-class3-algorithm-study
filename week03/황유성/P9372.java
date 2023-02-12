import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 주어지는 비행 스케줄은 항상 연결 그래프를 이루므로, 항상 모든 노드를 연결하는 스패닝 트리가 존재한다
 * 2. 이같은 트리의 (간선의 개수) = (노드의 개수 - 1)
 */
public class P9372 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                br.readLine();
            }
            answer.append(N - 1).append('\n');
        }
        System.out.println(answer);
    }
}

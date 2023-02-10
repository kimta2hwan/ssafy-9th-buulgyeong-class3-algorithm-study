import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. "오리가 원하는 땅 -> 루트" 로 가는 길에서 가장 마지막에 만나는 번호를 출력한다
 * 2. 부모 번호 = (자식 번호 >> 1)
 * 3. 시간 복잡도 O(QlogN)
 */

public class P20364 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();
        final int INIT = N + 1;
        boolean[] occupied = new boolean[N + 1];
        for (int i = 0; i < Q; i++) {
            int target = Integer.parseInt(br.readLine());
            int node = target;
            int min = INIT;
            while (node >= 1) {
                if (occupied[node]) min = node;
                node >>= 1;
            }
            if (min == INIT) {
                occupied[target] = true;
                answer.append(0).append('\n');
            } else {
                answer.append(min).append('\n');
            }
        }
        System.out.print(answer);
    }
}

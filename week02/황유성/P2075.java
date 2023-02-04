import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. '모든 수는 자신의 한 칸 위에 있는 수보다 크다'라는 조건을 이용하는 방법이 있을까?
 * 2. 조건과 별개로, 1500개의 원소를 저장하는 최소 힙을 이용하면 전체 로직의 시간 복잡도는 O(N^2 * logN)
 */

public class P2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            minPQ.add(Integer.valueOf(st.nextToken()));
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Integer num = Integer.valueOf(st.nextToken());
                if (num > minPQ.peek()) {
                    minPQ.poll();
                    minPQ.add(num);
                }
            }
        }
        System.out.println(minPQ.peek());
    }
}

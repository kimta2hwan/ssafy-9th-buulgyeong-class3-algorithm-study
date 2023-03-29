import java.io.*;
import java.util.*;

public class P21279 {

    /**
     * 1. N <= 50만이므로 O(NlogN) 풀이가 가능하다
     * 2. 직사각형의 한쪽 꼭짓점은 원점으로 고정되어 있으므로
     *  2.1) 세로 방향으로 스위핑을 하면서,
     *          비용 제한 내에서 최대한 너비를 늘리고 높이를 늘리면서 너비를 줄이기
     *  2.2) 가로 방향으로 스위핑을 하면서,
     *          비용 제한 내에서 최대한 높이를 늘리고 너비를 늘리면서 높이를 줄이기
     *  아니다. 이 방법은 너비/높이를 줄임에 따른 아름다운 정도의 감소량 계산을 위해 세그먼트 트리를 사용해야 한다.
     *  (정렬 + 세그먼트 트리)를 두 번 해야 하므로 시간이 빡빡하다.
     *  생각해 보니 세그먼트 트리 대신 우선순위 큐를 사용해도 구현 가능하다. 오히려 세그먼트 트리의 사용 방식이 더 복잡하다.
     *  또한 한 번 줄인 너비를 늘릴 수는 없으므로, 스위핑을 두 번 할 필요도 없다.
     *
     *  2.1) 광물을 x좌표값을 기준으로 오름차순 정렬한다
     *  2.2) 가로 방향으로 스위핑을 하면서, 우선순위 큐(y좌표값 내림차순)에 광물을 담는다
     *  2.3) 우선순위 큐의 원소 개수가 C를 초과하는 한, 맨앞 원소의 y값과 같은 원소를 모두 pop한다
     *
     */
    static int N, C;
    static Mineral[] minerals;
    static PriorityQueue<Mineral> pq = new PriorityQueue<>((m1, m2) -> m2.y - m1.y);

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        minerals = new Mineral[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            minerals[i] = new Mineral(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()));
        }
    }

    static void solve() {
        Arrays.sort(minerals);
        long answer = 0;
        long curSum = 0;
        int i = 0;
        while (i < N) {
            int curX = minerals[i].x;
            while (i < N && minerals[i].x == curX) {
                curSum += minerals[i].v;
                pq.offer(minerals[i++]);
            }
            while (pq.size() > C) {
                int curY = pq.peek().y;
                while (!pq.isEmpty() && pq.peek().y == curY) {
                    curSum -= pq.poll().v;
                }
            }
            answer = Math.max(answer, curSum);
        }

        System.out.println(answer);
    }


    static class Mineral implements Comparable<Mineral> {
        int x, y;
        long v;

        Mineral(int x, int y, long v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }

        @Override
        public int compareTo(Mineral o) {
            return this.x - o.x;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제 수 N <= 100_000
 * 명령문 수 M <= 10_000
 * 우선순위 큐를 이용하여 전체 로직의 시간 복잡도가 O(NlogN)이 되도록 하자
 * 제거 작업을 lazy하게 하기 위해 solved 배열을 관리하자
 *  단, 이때 인덱스는 P가 아니라 문제별 id값 (P는 중복되지만, id는 중복되지 않음)
 */
public class P21939 {
    static final int SZ = 100001;
    static int N, M, cnt;
    static PriorityQueue<Problem> minPQ = new PriorityQueue<>(
            (a, b) -> a.level == b.level ? a.num - b.num : a.level - b.level);
    static PriorityQueue<Problem> maxPQ = new PriorityQueue<>(
            (a, b) -> a.level == b.level ? b.num - a.num : b.level - a.level);
    static int[] idArr = new int[SZ];
    static boolean[] solved = new boolean[2 * SZ];
    static String[] queryArr;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            addProblem(P, L);
        }
        M = Integer.parseInt(br.readLine());
        queryArr = new String[M];
        for (int i = 0; i < M; i++) {
            queryArr[i] = br.readLine();
        }
    }

    static void solve() {
        for (String query : queryArr) {
            StringTokenizer st = new StringTokenizer(query);
            String cmd = st.nextToken();
            int P, L, x;
            switch (cmd) {
                case "add":
                    P = Integer.parseInt(st.nextToken());
                    L = Integer.parseInt(st.nextToken());
                    addProblem(P, L);
                    break;
                case "recommend":
                    x = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        while (!maxPQ.isEmpty() && solved[maxPQ.peek().id]) {
                            maxPQ.poll();
                        }
                        System.out.println(maxPQ.peek().num);
                    } else {
                        while (!minPQ.isEmpty() && solved[minPQ.peek().id]) {
                            minPQ.poll();
                        }
                        System.out.println(minPQ.peek().num);
                    }
                    break;
                case "solved":
                    P = Integer.parseInt(st.nextToken());
                    solved[idArr[P]] = true;
            }
        }
    }

    static void addProblem(int P, int L) {
        idArr[P] = ++cnt;
        Problem problem = new Problem(cnt, P, L);
        minPQ.offer(problem);
        maxPQ.offer(problem);
    }
}
class Problem {
    int id;
    int num;
    int level;

    Problem(int id, int num, int level) {
        this.id = id;
        this.num = num;
        this.level = level;
    }
}

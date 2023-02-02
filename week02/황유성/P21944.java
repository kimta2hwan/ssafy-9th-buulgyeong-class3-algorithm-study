import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 문제 추천 시스템 Version 1에서 살짝 변형되었다.
 * 2. 우선순위 큐를 402개 만들어 놓고 사용하자. = 최소/최대 2 * (분류 100 + 전체 1 + 난이도 100)
 * 3. 쿼리에 따라 다른 우선순위 큐, 특히 recommend3의 경우 반복문을 통해 난이도 순으로 여러 개의 우선순위 큐를 참조하도록 하자.
 */

public class P21944 {
    static final int SIZE = 100_000;
    static final int KIND = 101;
    static int N, M, cnt;
    static int[] idArr = new int[SIZE + 1];
    static boolean[] solved = new boolean[2 * SIZE];
    static String[] queryArr;
    static PriorityQueue<Problem>[] maxPQ1 = new PriorityQueue[KIND];
    static PriorityQueue<Problem>[] minPQ1 = new PriorityQueue[KIND];
    static PriorityQueue<Problem> maxPQ2 = new PriorityQueue<>(
            (a, b) -> a.level == b.level ? b.num - a.num : b.level - a.level);
    static PriorityQueue<Problem> minPQ2 = new PriorityQueue<>(
            (a, b) -> a.level == b.level ? a.num - b.num : a.level - b.level);
    static PriorityQueue<Problem>[] maxPQ3 = new PriorityQueue[KIND];
    static PriorityQueue<Problem>[] minPQ3 = new PriorityQueue[KIND];

    public static void main(String[] args) throws IOException {
        init();
        readInput();
        solve();
    }

    static void init() {
        for (int i = 0; i < KIND; i++) {
            maxPQ1[i] = new PriorityQueue<>((a, b) -> a.level == b.level ? b.num - a.num : b.level - a.level);
            minPQ1[i] = new PriorityQueue<>((a, b) -> a.level == b.level ? a.num - b.num : a.level - b.level);

            maxPQ3[i] = new PriorityQueue<>((a, b) -> a.level == b.level ? b.num - a.num : b.level - a.level);
            minPQ3[i] = new PriorityQueue<>((a, b) -> a.level == b.level ? a.num - b.num : a.level - b.level);
        }
    }

    static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            addProblem(new Problem(++cnt, P, L, G));
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
            int P, L, G, x;
            PriorityQueue<Problem> pq;
            switch (cmd) {
                case "add":
                    P = Integer.parseInt(st.nextToken());
                    L = Integer.parseInt(st.nextToken());
                    G = Integer.parseInt(st.nextToken());
                    addProblem(new Problem(++cnt, P, L, G));
                    break;
                case "solved":
                    P = Integer.parseInt(st.nextToken());
                    solved[idArr[P]] = true;
                    break;
                case "recommend":
                    G = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    pq = (x == 1 ? maxPQ1[G] : minPQ1[G]);
                    System.out.println(recommendProblem(pq));
                    break;
                case "recommend2":
                    x = Integer.parseInt(st.nextToken());
                    pq = (x == 1 ? maxPQ2 : minPQ2);
                    System.out.println(recommendProblem(pq));
                    break;
                case "recommend3":
                    x = Integer.parseInt(st.nextToken());
                    L = Integer.parseInt(st.nextToken());
                    int res = -1;
                    if (x == 1) {
                        for (int l = L; l < KIND; l++) {
                            pq = minPQ3[l];
                            res = recommendProblem(pq);
                            if (res != -1) {
                                System.out.println(res);
                                break;
                            }
                        }
                    } else {
                        for (int l = L - 1; l > 0; l--) {   // try 1) 오답. l = L에서 수정
                            pq = maxPQ3[l];
                            res = recommendProblem(pq);
                            if (res != -1) {
                                System.out.println(res);
                                break;
                            }
                        }
                    }
                    if (res == -1) System.out.println(-1);
                    break;
            }
        }
    }

    static void addProblem(Problem p) {
        minPQ1[p.category].offer(p);
        maxPQ1[p.category].offer(p);
        minPQ2.offer(p);
        maxPQ2.offer(p);
        minPQ3[p.level].offer(p);
        maxPQ3[p.level].offer(p);
        idArr[p.num] = p.id;
    }
    static int recommendProblem(PriorityQueue<Problem> pq) {
        while (!pq.isEmpty() && solved[pq.peek().id]) {
            pq.poll();
        }
        return (pq.isEmpty() ? -1 : pq.peek().num);
    }
}

class Problem {
    int id;
    int num;
    int level;
    int category;

    Problem(int id, int num, int level, int category) {
        this.id = id;
        this.num = num;
        this.level = level;
        this.category = category;
    }
}
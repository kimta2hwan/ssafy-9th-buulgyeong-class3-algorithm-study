import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class P14567 {
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        List<List<Integer>> edges = new ArrayList<>();
        int[] edgeCount = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        while (M-- > 0) {
            int A = read();
            int B = read();

            edges.get(A).add(B);
            edgeCount[B]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (edgeCount[i] == 0) {
                queue.offer(i);
                answer[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : edges.get(curr)) {
                edgeCount[next]--;

                if (edgeCount[next] == 0) {
                    answer[next] = answer[curr] + 1;
                    queue.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append(' ');
        }

        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}

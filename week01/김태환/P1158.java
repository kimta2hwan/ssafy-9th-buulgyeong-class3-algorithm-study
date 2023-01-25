import java.util.LinkedList;
import java.util.Queue;

class P1158 {
    public static void main(String[] args) throws Exception {
        solution();
    }
    
    private static void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        int N = read();
        int K = read();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        sb.append('<');

        while (q.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }

            sb.append(q.poll()).append(',').append(' ');
        }

        sb.append(q.poll()).append('>');
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class P5430 {

    private static Deque<Integer> deque;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<>();

            while (n-- > 0) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }
            
            ac(commands);
        }

        System.out.println(sb);
    }

    private static void ac(String commands) {
        boolean flag = true;

        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                flag = !flag;
                continue;
            }

            if (deque.isEmpty()) {
                sb.append("error").append('\n');
                return;
            }

            if (flag) {
                deque.pollFirst();

            } else {
                deque.pollLast();
            }
        }

        sb.append('[');

        while (!deque.isEmpty()) {  
                sb.append(flag ? deque.pollFirst() : deque.pollLast());

            if (!deque.isEmpty()) {
                sb.append(',');
            }
        }

        sb.append(']').append('\n');
    }
}

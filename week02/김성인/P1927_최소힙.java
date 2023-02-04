import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int result = 0;

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                result = heap.size() == 0 ? 0 : heap.poll();
                sb.append(result).append("\n");
            } else {
                heap.offer(num);
            }
        }
        System.out.println(sb);
    }
}

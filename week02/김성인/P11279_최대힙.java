import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class P11279_최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(heap.peek() == null ? 0 : heap.poll()).append("\n");
            } else {
                heap.add(num);
            }
        }

        System.out.println(sb);
    }
}

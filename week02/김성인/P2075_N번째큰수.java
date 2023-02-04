import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2075_N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                priorityQueue.add(Integer.parseInt(st.nextToken()));
            }
        }
        while (n-- > 0) {
            if (n == 0) {
            System.out.println(priorityQueue.peek());
            }
            priorityQueue.poll();
        }
    }
}
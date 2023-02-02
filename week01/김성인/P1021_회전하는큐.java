import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1021_회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        int result = 0;

        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int target = list.indexOf(Integer.parseInt(st.nextToken()));
            int bTarget = list.size() - target;
            if (target > bTarget) { // bTarget이 효율
                for (int i = 0; i < bTarget; i++) {
                    list.addFirst(list.removeLast()); // 뒷편 빼기
                }
                result += bTarget;
            } else {
                for (int i = 0; i < target; i++) {
                    list.addLast(list.removeFirst()); // 앞편 빼기
                }
                result += target;
            }
            list.removeFirst(); // 빼기
        }
        System.out.println(result);
    }
}

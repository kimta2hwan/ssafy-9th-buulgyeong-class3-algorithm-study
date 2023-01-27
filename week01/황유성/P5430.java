import java.io.*;
import java.util.*;

public class P5430 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bw.write(solve());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
    /*
    * 1. O(N)의 뒤집는 연산을 실제로 수행하면 전체 로직의 시간 복잡도는 O(TPN)으로 시간 초과가 뜬다. (P는 p의 길이)
    * 2. 뒤집기 여부에 따라 덱의 앞에서 뺄지 뒤에서 뺄지를 결정하면 전체 로직의 시간 복잡도는 O(TN)으로 넉넉하다.
    * 3. 한편 StringBuilder를 사용하지 않고, String의 덧셈을 하게 되면 전체 로직의 시간 복잡도는 O(TN^2)으로 시간 초과가 뜬다.
    * */

    static String solve() throws IOException {
        String func = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String arr = br.readLine();
        arr = arr.substring(1, arr.length() - 1);
        StringTokenizer st = new StringTokenizer(arr, ",");
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            dq.offerLast(Integer.valueOf(st.nextToken()));
        }
        boolean reverse = false;
        for (char c : func.toCharArray()) {
            if (c == 'R')           reverse = !reverse;
            else if (dq.isEmpty())  return "error";
            else if (reverse)       dq.pollLast();
            else                    dq.pollFirst();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (reverse) {
            while (dq.size() > 1) {
                sb.append(dq.pollLast());
                sb.append(",");
            }
        } else {
            while (dq.size() > 1) {
                sb.append(dq.pollFirst());
                sb.append(",");
            }
        }
        if (!dq.isEmpty()) {
            sb.append(dq.pollLast());
        }
        sb.append("]");
        return sb.toString();
    }
}

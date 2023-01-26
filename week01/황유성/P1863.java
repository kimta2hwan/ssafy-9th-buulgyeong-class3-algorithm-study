import java.io.*;
import java.util.*;

/***
 * 1. x 좌표는 사용하지 않아도 된다
 * 2. 각 건물의 높이를 스택에 넣기 전에
 *  1) 스택에 더 높은 값이 있는 경우 pop하고 세어준다. 해당 값을 높이로 갖는 건물이 끝난 셈이므로.
 *  2) 스택에 같은 값이 있는 경우, 스택에 넣지 않는다. 해당 값을 높이로 갖는 건물과 같은 건물로 볼 수 있으므로.
 *  3) 스택에 더 낮은 값이 있는 경우에만 push한다.
 * 3. 끝부분에 도달했을 때 남아있는 스택에서 0을 제외한 원소의 개수를 세어준다.
 */

public class P1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            heights[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int height : heights) {
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
                answer++;
            }
            if (stack.isEmpty() || stack.peek() < height) {
                stack.push(height);
            }
        }
        while (!stack.isEmpty() && stack.peek() > 0) {
            stack.pop();
            answer++;
        }
        System.out.println(answer);
    }
}


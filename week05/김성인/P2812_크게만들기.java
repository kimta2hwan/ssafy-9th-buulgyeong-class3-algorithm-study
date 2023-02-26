import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P2812_크게만들기 {
    static int N, K;
    static String number;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        number = br.readLine();

        Stack<Character> stack = new Stack<>();
        // 첫번째 숫자는 넣고 시작
        stack.push(number.charAt(0));
        int cnt = 0;
        boolean flag = true;

        for (int i = 1; i < number.length(); i++) {
            char ch = number.charAt(i);

            while (!stack.isEmpty() && flag) {
                // 숫자를 K개 지웠을 경우 탈출
                if (cnt == K) {
                    flag = false;
                    break;
                }
                // 스택에 들어있는 값보다 ch가 큰 경우 제거
                if (stack.peek() < ch) {
                    stack.pop();
                    cnt += 1;
                }
                // 반대인 경우 반복문 탈출
                else if (stack.peek() >= ch) {
                    break;
                }
            }
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        // 반복문을 돌았지만 제거해야될 숫자 갯수를 충족하지 못할 경우
        if (cnt < K) {
            // 스택 사이즈에 남은 수를 뺸만큼만 추가
            int gap = K - cnt;
            for (int i = 0; i < stack.size() - gap; i++) {
                sb.append(stack.get(i));
            }
        } else {
            for (Character c : stack) {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
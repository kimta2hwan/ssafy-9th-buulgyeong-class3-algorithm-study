import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            boolean balance = true;

            if (str.equals(".")) {
                break;
            }
            for (char c : str.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')' && (stack.size() == 0 || stack.pop() != '(')) {
                    balance = false;
                    break;
                } else if (c == ']' && (stack.size() == 0 || stack.pop() != '[')) {
                    balance = false;
                    break;
                }
            }
            if (stack.size() != 0) balance = false;
            sb.append(balance ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }
}

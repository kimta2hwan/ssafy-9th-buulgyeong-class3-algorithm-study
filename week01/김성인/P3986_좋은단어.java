import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P3986_좋은단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() % 2 != 0) continue;

            Stack<Character> stack = new Stack<>();

            for (char c : str.toCharArray()) {
                if (!stack.empty() && c == stack.lastElement()) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }

            if (stack.size() == 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}

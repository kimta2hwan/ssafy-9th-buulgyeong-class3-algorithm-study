import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P3986_좋은단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() % 2 != 0) continue;

            LinkedList<Character> list = new LinkedList<>();

            for (int j = 0; j < str.length(); j++) {
                list.add(str.charAt(j));
            }

            int cnt = 1;
            while (cnt < list.size()) {
                if (list.get(cnt - 1) == list.get(cnt)) {
                    list.remove(cnt);
                    list.remove(cnt - 1);
                    cnt = cnt == 1 ? 1: cnt - 1;
                } else {
                    cnt++;
                }
            }
            if (list.size() == 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}

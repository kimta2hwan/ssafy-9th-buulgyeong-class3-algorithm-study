import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P2745_진법변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        char[] chars = st.nextToken().toCharArray();
        int b = Integer.parseInt(st.nextToken());

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) (i + 65), i + 10);
        }

        int sum = 0;
        int num;
        for (int i = 0; i < chars.length; i++) {
            num = map.containsKey(chars[i]) ? map.get(chars[i]) : (chars[i] - 48); // 알파벳인지 체크
            sum += num * Math.pow(b, chars.length - i - 1);
        }
        System.out.println(sum);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int result = 1;
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }

            for (Integer val : map.values()) {
                result *= ++val;
            }
            sb.append(result - 1).append("\n");
        }
        System.out.println(sb);
    }
}

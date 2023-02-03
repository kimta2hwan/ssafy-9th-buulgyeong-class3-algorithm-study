import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P14425_문자열집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;
        HashSet<String> set = new HashSet<>();
        while (n-- > 0) {
            set.add(br.readLine());
        }

        while (m-- > 0) {
            if (set.contains(br.readLine())){
                result++;
            }
        }
        System.out.println(result);
    }
}

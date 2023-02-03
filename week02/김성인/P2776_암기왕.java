import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P2776_암기왕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            HashSet<Integer> hSet = new HashSet<>();

            for (int i = 0; i < n; i++) {
                hSet.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while (m-- > 0) {
                int result = 0;
                int target = Integer.parseInt(st.nextToken());
                if (hSet.contains(target)) result = 1;

                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
}

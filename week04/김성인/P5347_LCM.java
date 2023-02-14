import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5347_LCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int min = Math.min(a, b);
            int max = Math.max(a, b);
            long[] common = new long[min];
            for (int i = 1; i <= min; i++) {
                common[i - 1] = (long) max * i;
            }
            for (long i : common) {
                if (i % min == 0) {
                    sb.append(i).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

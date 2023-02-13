import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1934_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int min = Math.min(a, b);
            int max = Math.max(a, b);

            int[] list1 = new int[min];
            if (min == 1) {
                sb.append(max);
            } else {
                for (int j = 1; j <= min; j++) {
                    list1[j - 1] = max * j;
                }
                for (int l : list1) {
                    if (l % min == 0) {
                        sb.append(l);
                        break;
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

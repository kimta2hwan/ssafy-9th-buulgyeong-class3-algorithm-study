import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1978_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        while (n-- > 0) {
            boolean isP = true;
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                continue;
            }

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isP = false;
                    break;
                }
            }

            if (isP) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

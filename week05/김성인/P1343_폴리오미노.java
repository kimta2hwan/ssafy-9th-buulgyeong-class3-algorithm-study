import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1343_폴리오미노 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] temp = br.readLine().toCharArray();
        int cnt = 0;
        int answer = 0;

        for (char c : temp) {
            if (c == 'X') {
                cnt++;
            } else {
                if (cnt % 2 != 0) {
                    answer = -1;
                    break;
                }
                while (cnt >= 4) {
                    sb.append("AAAA");
                    cnt -= 4;
                }
                if (cnt != 0) {
                    sb.append("BB");
                    cnt = 0;
                }
                sb.append(".");
            }
        }
        if (cnt != 0) {
            if (cnt % 2 != 0) {
                answer = -1;
            }
            while (cnt >= 4) {
                sb.append("AAAA");
                cnt -= 4;
            }
            if (cnt != 0) {
                sb.append("BB");
            }
        }
        if (answer == -1) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P20365_블로그2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] problems = br.readLine().toCharArray();

        int bCnt = 0;
        int rCnt = 0;
        int index = 0;

        while (index < n) {
            if (problems[index] == 'B') {
                while (index + 1 < n && problems[index + 1] == 'B') {
                    index++;
                }
                bCnt++;
            } else {
                while (index + 1 < n && problems[index + 1] == 'R') {
                    index++;
                }
                rCnt++;
            }
            index++;
        }
        System.out.println(Math.min(bCnt, rCnt) + 1);
    }
}

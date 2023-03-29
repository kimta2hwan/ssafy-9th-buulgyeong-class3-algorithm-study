import java.io.*;
import java.util.*;

public class P20207 {

    static int N;
    static int[] count = new int[366];

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s; j <= e; j++) {
                count[j]++;
            }
        }
    }

    static void solve() {
        int answer = 0;
        int maxCnt = 0, prevS = 0;
        for (int i = 1; i <= 365; i++) {
            if (prevS == 0 && count[i] > 0) prevS = i;
            if (count[i] > maxCnt) maxCnt = count[i];
            if (prevS != 0 && count[i] == 0) {
                answer += maxCnt * (i - prevS);
                maxCnt = prevS = 0;
            }
        }
        answer += maxCnt * (366 - prevS); // try 1) WA. 365일째에 일정의 개수가 1 이상이어서 계산되지 않는 오류 수정
        System.out.println(answer);
    }
}

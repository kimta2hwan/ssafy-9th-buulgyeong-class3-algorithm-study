import java.util.*;
import java.io.*;

public class P15565 {

    static int N, K;
    static boolean[] isRyan;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isRyan = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            isRyan[i] = st.nextToken().equals("1");
        }
    }

    static void solve() {
        int answer = Integer.MAX_VALUE;
        int lp = 0, rp = 1;
        int ryanCnt = (isRyan[0] ? 1 : 0);
        while (lp < N) {
            if (ryanCnt >= K) {
                answer = Math.min(answer, rp - lp);
                if (isRyan[lp++]) ryanCnt--;
            } else if (rp < N) {
                if (isRyan[rp++]) ryanCnt++;
            } else {
                break;
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        // try 1) WA. answer이 초기값 그대로일 경우 -1을 출력하는 코드 누락
    }
}

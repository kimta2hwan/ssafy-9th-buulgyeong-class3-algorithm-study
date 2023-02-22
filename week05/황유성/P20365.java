import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1. 빨간색만 있거나 파란색만 있다면 답은 1
 * 2. 그렇지 않다면, 맨 처음 파란색으로 다 칠해 놓고, 연속하는 빨간색 구간 개수만큼 칠하면 된다 (연속하는 빨간색 구간이 더 적은 경우에만)
 * 3. 즉 답은 1 + (연속하는 빨간색 구간의 개수)
 */
public class P20365 {

    static int N;
    static char[] input;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();
    }

    static void solve() {
        char prev = 'X';
        int cntR = 0, cntB = 0;
        for (char cur : input) {
            if (cur == prev) continue;
            if (cur == 'R') {
                cntR++;
            } else {
                cntB++;
            }
            prev = cur;
        }
        if ((cntR & cntB) == 0) {
            System.out.println(1);
        } else {
            System.out.println(1 + Math.min(cntR, cntB));
        }
    }
}

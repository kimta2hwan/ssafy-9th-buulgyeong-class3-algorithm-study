import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1. 연속하는 M과 K를 붙였을 때 최댓값 + 마지막까지 M만 연속하는 경우 각각을 1로 고려해야 최댓값
 * 2. K를 모든 M과 분리할 때 최솟값 + 마지막까지 M만 연속하는 경우 결합해야 최솟값
 */
public class P21314 {

    static char[] inp;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inp = br.readLine().toCharArray();
    }

    static void solve() {
        StringBuilder max = new StringBuilder();
        int cntM = 0;
        for (char c : inp) {
            if (c == 'M') cntM++;
            else {
                max.append('5');
                for (int i = 0; i < cntM; i++) {
                    max.append('0');
                }
                cntM = 0;
            }
        }
        for (int i = 0; i < cntM; i++) {
            max.append('1');                // try 2) WA. 마지막 M을 처리할 때 최댓값을 만들지 않는 오류
        }

        StringBuilder min = new StringBuilder();
        cntM = 0;
        for (char c : inp) {
            if (c == 'M') cntM++;
            else {
                if (cntM > 0) min.append('1');
                for (int i = 1; i < cntM; i++) {
                    min.append('0');
                }
                min.append('5');
                cntM = 0;
            }
        }
        if (cntM > 0) min.append('1');      // try 1) WA. 마지막 M을 처리하는 코드 누락
        for (int i = 1; i < cntM; i++) {
            min.append('0');
        }

        System.out.println(max);
        System.out.println(min);
    }
}

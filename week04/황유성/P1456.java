import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 우선 10^7 까지의 소수를 모두 구한다 O(Nlog(logN)) = 약 5천만
 * 2. 각 소수마다 B를 넘지 않는 범위 안에서 거듭제곱을 하며 개수를 카운팅한다
 *      -> 소수의 크기가 증가할수록 거듭제곱의 수는 지수적으로 감소한다 (ex. 대략 10^5 이상의 소수는 거듭제곱을 한 번만 하게 된다)
 * 3. (소수 x의 N제곱)은 (소수 y 및 그 모든 거듭제곱)과 서로소이므로, 중복의 여지가 없다
 */
public class P1456 {

    static BigInteger A, B;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }
    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new BigInteger(st.nextToken());
        B = new BigInteger(st.nextToken());
    }
    static void solve() {
        boolean[] isPrime = new boolean[10_000_001];
        Arrays.fill(isPrime, true);

        int answer = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
                BigInteger w = new BigInteger(String.valueOf(i));
                BigInteger num = w.multiply(w);
                while (num.compareTo(B) != 1) {             // try 1) WA. long 사용 시 오버플로우로 인해 조건문에 오류 발생
                    if (num.compareTo(A) != -1) answer++;
                    num = num.multiply(w);
                }
            }
        }
        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1. 시간 복잡도 O(D * sqrtN) (D는 소수 사이의 최대 간격) 풀이가 최선이다
 * 2. N이 최대 4 * 10^9 이므로, sqrtN <= 6 * 10^4, D는 대략 10^3 이하여야 한다
 * 3. 에라토스테네스의 체를 이용해 2 ~ 20억 사이의 D를 구해보니 292 이다
 * 4. 2 ~ 40억 1000 사이의 D 또한 10^3 이하이지 않을까?
 */

public class P4134 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long n;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            readTestCase();
            solve();
        }
        System.out.print(answer);
        System.out.println(count());
    }
    static void readTestCase() throws Exception {
        n = Long.parseLong(br.readLine());
    }

    static void solve() {
        while (true) {
            if (isPrime(n)) {            // try 2) WA. 크거나 '같은' 소수
                answer.append(n).append('\n');
                break;
            }
            n++;
        }
    }

    static boolean isPrime(long num) {
        if (num < 2) return false;         // try 1) WA. n=0일 때 1을 출력하는 오류 수정

        int sqrt = (int)Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    static int count() {
        int diffMax = 0;
        boolean[] isPrime = new boolean[2000000001];
        Arrays.fill(isPrime, true);
        int prev = 2;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                diffMax = Math.max(diffMax, i - prev);
                prev = i;
                for (int j = i; j < isPrime.length - i; j += i) {
                    isPrime[j + i] = false;
                }
            }
        }
        return diffMax;
    }
}

import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 1. 36^2가지 경우의 수에 대해 완전 탐색으로 답을 구할 수 있다
 * 2. X는 정수 범위 이내이므로 BigInteger를 고려하지 않아도 된다(X) -> BigInteger로 정수 범위 초과 여부를 따져야 한다
 * 3. A 표현값에 a가 포함되어 있다면 1~10진수의 가능성은 배제해야 한다. 만약 포함하게 되면 로직 에러 발생 가능하다
 */
public class P21275 {
    static char[] charArrA, charArrB;
    static BigInteger LIMIT = new BigInteger(String.valueOf(Long.MAX_VALUE));
    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }
    static void readInput() throws Exception {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        charArrA = st.nextToken().toCharArray();
        charArrB = st.nextToken().toCharArray();
    }
    static void solve() {
        int[] numA = charArrToIntArr(charArrA);
        int[] numB = charArrToIntArr(charArrB);

        int maxA = IntStream.of(numA).max().orElse(0);  // try 1) WA. 최솟값이 아니라 최댓값을 하한선으로 삼아야 한다
        int maxB = IntStream.of(numB).max().orElse(0);

        String answer = null;
        for (int a = maxA + 1; a <= 36; a++) {
            for (int b = maxB + 1; b <= 36; b++) {
                if (a == b) continue;
                BigInteger resA = decode(numA, a);
                BigInteger resB = decode(numB, b);
                if (resA.compareTo(LIMIT) < 1 && resA.equals(resB)) {
                    if (answer == null) {
                        answer = String.format("%d %d %d", resA, a, b);
                    } else {
                        System.out.println("Multiple");
                        return;
                    }
                }
            }
        }
        System.out.println((answer == null ? "Impossible" : answer));
    }
    static int[] charArrToIntArr(char[] charArr) {
        int[] ret = new int[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            ret[i] = (charArr[i] >= 'a' ? charArr[i] - 'a' + 10 : charArr[i] - '0');
        }
        return ret;
    }
    static BigInteger decode(int[] numArr, int radix) {
        BigInteger ret = new BigInteger("0");
        for (int num : numArr) {
            ret = ret.multiply(new BigInteger(String.valueOf(radix)));
            ret = ret.add(new BigInteger(String.valueOf(num)));
        }
        return ret;
    }
}

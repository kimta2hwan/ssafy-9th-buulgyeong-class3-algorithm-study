import java.util.Scanner;
/**
 * 1. 소수 && 팰린드롬을 찍어보면서 확인 -> 1,003,001이 소수이면서 팰린드롬이므로 그 이상의 수는 고려하지 않아도 된다
 * 2. 다른 문제에서 N = 100만일 때 O(NloglogN) = 약 500만
 * 3. 따라서 에라토스테네스의 체를 사용해도 안정적이다
 */
public class P1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] isPrime = new boolean[1_003_002];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = N; i < isPrime.length; i++) {
            if (isPrime[i] && isPalindrome(i)) {
                System.out.print(i);
                return;
            }
        }
    }
    static boolean isPalindrome(int num) {
        char[] cArr = String.valueOf(num).toCharArray();
        int size = cArr.length;
        for (int i = 0; i < size / 2; i++) {
            if (cArr[i] != cArr[size - i - 1])
                return false;
        }
        return true;
    }
}

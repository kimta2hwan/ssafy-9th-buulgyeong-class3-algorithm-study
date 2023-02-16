import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1. 100만 번의 소수 판정을 해야 하므로, O(Nlog(logN))의 에라토스테네스 체를 사용한다
 * 2. 제곱의 합 계산값은 600을 넘을 수 없다
 */
public class P9421 {

    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = i + i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        check = new int[600];
        int turn = 1;
        for (int prime : primes) {
            if (sg(prime, turn++)) answer.append(prime).append('\n');
        }
        System.out.println(answer);
    }
    static boolean sg(int curNum, int turn) {
        int nextNum;
        while (curNum != 1) {
            nextNum = 0;
            while (curNum > 0) {
                nextNum += (int) Math.pow(curNum % 10, 2);
                curNum /= 10;
            }
            if (check[nextNum] == turn) return false;
            check[nextNum] = turn;
            curNum = nextNum;
        }
        return true;
    }
}

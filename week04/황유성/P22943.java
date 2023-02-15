import java.util.ArrayList;
import java.util.Scanner;
/**
 * 1. 만들 수 있는 수의 개수 = 9 * 9 * 8 * 7 * 6 = 27216개
 * 2. 우선 에라토스테네스의 체로 98765 미만의 소수를 모두 구해 놓자
 * 3. 완전 탐색을 통해 만든 수 X에 대해
 * 4. 조건 (1): 소수 합의 배열을 만들어 놓는다
 * 5. 조건 (2): O(sqrtX)로 완전 탐색한 결과 존재한다
 */
public class P22943 {
    static int K, M;
    static boolean[] isPrime = new boolean[98766];
    static boolean[] isTwoPrime = new boolean[98766];
    static boolean[] used = new boolean[10];
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }
    static void readInput() throws Exception {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        M = sc.nextInt();
    }
    static void solve() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                list.add(i);
                for (int j = i + i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            int iVal = list.get(i);
            for (int j = i + 1; j < list.size() && iVal + list.get(j) < isPrime.length; j++) {
                isTwoPrime[iVal + list.get(j)] = true;
            }
        }

        perm(0, 0);
        System.out.println(ans);
    }
    static void perm(int depth, int num) {
        if (depth == K) {
            if (!isTwoPrime[num]) return;
            while (num % M == 0) {
                num /= M;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (isPrime[i] && num % i == 0 && isPrime[num / i]) {
                    ans++;
                    return;
                }
            }
            return;
        }
        int start = (depth == 0 ? 1 : 0);
        for (int i = start; i < 10; i++) {
            if (used[i]) continue;
            used[i] = true;
            perm(depth + 1, 10 * num + i);
            used[i] = false;
        }
    }
}

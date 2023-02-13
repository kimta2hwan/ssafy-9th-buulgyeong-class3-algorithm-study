import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 에라토스테네스의 체 시간 복잡도 O(NloglogN) = 약 3천만 으로 애매하다
 * 2. 수열의 수 하나당 소수 판정법 -> 전체 시간 복잡도 O(NsqrtN) = 약 100만 으로 안정적이다
 * 3. 소수들의 최소공배수는 소수들의 곱과 같다 -> 같은 소수가 주어질 수 있으므로 중복 처리를 해 줘야 한다.
 */
public class P21919 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> usedSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime(num) && !usedSet.contains(num)) { // try 1) WA. 중복 처리를 위해 수정
                answer *= num;
                usedSet.add(num);
            }
        }
        System.out.println((answer == 1 ? -1 : answer));
    }
    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

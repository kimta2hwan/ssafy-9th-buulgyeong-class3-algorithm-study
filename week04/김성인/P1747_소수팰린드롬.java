import java.util.Scanner;

public class P1747_소수팰린드롬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean isPrime = true;

        while (true) {
            if (n == 1) {
                n++;
                break;
            }
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                char[] chars = String.valueOf(n).toCharArray();
                for (int i = 0; i < chars.length / 2; i++) {
                    if (chars[i] != chars[chars.length - i - 1]) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) break;
            }
            n++;
            isPrime = true;
        }
        System.out.println(n);
    }
}

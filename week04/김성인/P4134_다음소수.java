import java.util.Scanner;

public class P4134_다음소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            while (!prime(n)) {
                n++;
            }
            System.out.println(n);

        }
    }

    public static boolean prime(long a) {
        if (a < 2) return false;
        for (long i = 2; i * i <= a; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }
}

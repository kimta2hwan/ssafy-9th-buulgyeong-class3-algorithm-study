import java.util.Scanner;

public class P21312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int ans = 1;
        if (A % 2 == 0 && B % 2 == 0 && C % 2 == 0) {
            ans = A * B * C;
        } else {
            if (A % 2 == 1) ans *= A;
            if (B % 2 == 1) ans *= B;
            if (C % 2 == 1) ans *= C;
        }
        System.out.print(ans);
    }
}

import java.util.Scanner;
/**
 * g가 x, y의 최대 공약수이고 x = ga, y = gb일 때 (a, b는 서로소)
 * 정답은 (a * b의 대각선 그려진 타일의 개수) * g 이다
 * a, b가 서로소인 직사각형에서 대각선 그려진 타일의 개수 = a + b - 1
 */
public class P2168 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int g = gcd(x, y);
        int a = x / g;
        int b = y / g;
        long answer = (long)(a + b - 1) * g;
        System.out.println(answer);
    }
    static int gcd(int x, int y) {
        while (y > 0) {
            int tmp = x;
            x = y;
            y = tmp % y;
        }
        return x;
    }
}

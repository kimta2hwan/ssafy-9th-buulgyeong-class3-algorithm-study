import java.util.Scanner;

/**
(X) 정답은 N!을 소인수분해 했을 때 min(2의 지수, 5의 지수) (X)
마지막 자릿수 위의 숫자들은 앞으로 마지막 자릿수에 영향을 주지 않기 때문에 고려하지 않아도 된다
따라서 정답은 곱셈을 거듭할 때마다 0이 아닌 마지막 자릿수만 추적했을 때 남아있는 숫자다
아니다. 25에 4가 곱해지는 경우가 반례다.
2 또는 5에 서로소인 수들은 0을 만드는 데 아무런 영향을 주지 않는다
따라서 이같은 수들은 일의 자릿수만 고려해도 된다
*/
public class P2553 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int ans = 1;
        int cnt2 = 0;
        int cnt5 = 0;
        for (int i = 2; i <= N; i++) {
            int num = i;
            while (num % 2 == 0) {
                num /= 2;
                cnt2++;
            }
            while (num % 5 == 0) {
                num /= 5;
                cnt5++;
            }
            ans = (ans * num) % 10;
        }
        int diff = cnt2 - cnt5;
        for (int i = 0; i < diff; i++) {
            ans = (2 * ans) % 10;
        }
        System.out.println(ans);
    }
}

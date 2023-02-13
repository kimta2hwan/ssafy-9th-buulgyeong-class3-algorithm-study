import java.util.Scanner;

public class P1110_더하기사이클 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ten = n / 10, one = n % 10;
        int sum = ten + one; // ten + one 하고 one과 나온 수 n가 같은 지 체크
        int temp = -1;
        int cnt = 0;
        while (temp != n) {
            temp = one * 10 + sum % 10;
            ten = temp / 10;
            one = temp % 10;
            sum = ten + one;
            cnt++;
        }
        System.out.println(cnt);
    }
}

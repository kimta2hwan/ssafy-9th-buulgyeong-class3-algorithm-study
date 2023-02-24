import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16953_AB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = 1;
        // b의 1의자리가 1이면 떼고 아니면 나누어서 a가 되는지 체크한다.
        // 이때 a보다 연산 결과가 작아진다면? -1을 출력한다.
        while (b > a) {
            if (b % 10 == 1) b /= 10;
            else if (b % 2 == 0) b /= 2;
            else break;
            cnt++;
        }
        System.out.println(b == a ? cnt : -1);
    }
}

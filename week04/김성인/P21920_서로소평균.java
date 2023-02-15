import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21920_서로소평균 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long sum = 0;
        int cnt = 0;

        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            if (gcd(x, ints[i]) == 1) {
                // 더하기
                sum += ints[i];
                cnt++;
            }
        }
        System.out.println((float) sum / cnt);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

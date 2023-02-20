import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class P21920 {

    static int N, X;
    static int[] A;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());
    }

    static void solve() {
        double answer = Arrays.stream(A).filter(e -> isDisjoint(e)).average().orElse(0.0);
        System.out.println(answer);
    }

    static boolean isDisjoint(int num) {
        return gcd(num, X) == 1;
    }

    static int gcd(int a, int b) {
        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}

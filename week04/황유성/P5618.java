import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;


public class P5618 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        StringBuilder answer = new StringBuilder();
        final int g = Arrays.stream(arr).reduce((a, b) -> gcd(a, b)).orElse(0);
        IntStream.rangeClosed(1, g).filter(e -> g % e == 0).forEach(e -> answer.append(e).append('\n'));
        System.out.println(answer);
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

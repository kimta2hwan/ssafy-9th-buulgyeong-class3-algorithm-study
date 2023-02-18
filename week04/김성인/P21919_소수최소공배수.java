import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P21919_소수최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long result = 1;
        int n = Integer.parseInt(br.readLine());
        long[] longs = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            longs[i] = Long.parseLong(st.nextToken());
        }
        HashSet<Long> prime = new HashSet<>();
        for (long l : longs) {
            boolean isPrime = true;
            for (long i = 2; i * i <= l; i++) {
                if (l % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                prime.add(l);
            }
        }
        for (long l : prime) {
            result *= l;
        }
        if (result == 1) result = -1;
        System.out.println(result);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] wait = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            wait[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wait);

        for (int i = 0; i < n; i++) {
            result += wait[i] * (n - i);
        }
        System.out.println(result);
    }
}

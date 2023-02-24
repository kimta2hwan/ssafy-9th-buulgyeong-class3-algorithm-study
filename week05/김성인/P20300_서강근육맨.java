import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20300_서강근육맨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        long[] machine = new long[n];
        for (int i = 0; i < n; i++) {
            machine[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(machine);
        long max = 0;
        for (int i = 0; i < n / 2; i++) {
            if (n % 2 == 0) max = Math.max(max, machine[i] + machine[n - i - 1]);
            else max = Math.max(max, machine[i] + machine[n - i - 2]);
        }

        System.out.println(max);

    }
}

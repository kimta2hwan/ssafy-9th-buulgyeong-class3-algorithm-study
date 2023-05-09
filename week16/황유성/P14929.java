import java.io.*;
import java.util.*;

public class P14929 {

    static int n;
    static int[] x, pSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        x = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        pSum = new int[n + 1];
        for (int i = n - 1; i > 0; i--) {
            pSum[i] = pSum[i + 1] + x[i];
        }

        long answer = 0;
        for (int i = 1; i < n; i++) {
            answer += (long) x[i - 1] * pSum[i];
        }
        System.out.println(answer);
    }
}

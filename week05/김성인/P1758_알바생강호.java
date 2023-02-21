import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class P1758_알바생강호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] cus = new Integer[n];
        long tip = 0;

        for (int i = 0; i < n; i++) {
            cus[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cus, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if (cus[i] - i > 0) tip += (cus[i] - i);
            else break;
        }
        System.out.println(tip);
    }
}

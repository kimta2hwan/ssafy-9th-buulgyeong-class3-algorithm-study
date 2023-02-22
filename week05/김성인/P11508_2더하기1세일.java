import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class P11508_2더하기1세일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] items = new Integer[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(items, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if ((i / 3) * 3 + 2 != i) {
                answer += items[i];
            }
        }

        System.out.println(answer);


    }
}

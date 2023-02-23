import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P20115_에너지드링크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Integer[] drinks = new Integer[n];

        for (int i = 0; i < n; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(drinks, Collections.reverseOrder());

        double mixed = drinks[0];

        for (int i = 1; i < n; i++) {
            double temp = (double) drinks[i] / 2;
            mixed += temp;
        }

        System.out.println(mixed);

    }
}

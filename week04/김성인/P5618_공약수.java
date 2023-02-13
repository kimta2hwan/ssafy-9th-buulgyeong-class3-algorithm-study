import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5618_공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] ints = new int[n];

        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ints);

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i * i <= ints[0]; i++) {
            if (ints[0] % i == 0) {
                result.add(i);
                if (i != ints[0] / i) result.add(ints[0] / i);
            }
        }

        for (int i = 1; i < n; i++) {
            ArrayList<Integer> sub = new ArrayList<>();
            for (Integer integer : result) {
                if (ints[i] % integer != 0) {
                    sub.add(integer);
                }
            }
            result.removeAll(sub);
        }
        Object[] answer = result.toArray();
        Arrays.sort(answer);
        for (Object o : answer) {
            sb.append(o).append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int min = Math.min(a, b);
        int max = Math.max(a, b);
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 1; i * i <= min; i++) {
            if (min % i == 0) {
                list1.add(i);
                if (min / i != i) {
                    list1.add(min / i);
                }
            }
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i : list1) {
            if (max % i == 0) {
                list2.add(i);
            }
        }
        Collections.sort(list2);
        System.out.println(list2.get(list2.size() - 1));

        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 1; i <= min; i++) {
            list3.add(max * i);
        }
        for (int i : list3) {
            if (i % min == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}

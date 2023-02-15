import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P9613_GCD합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            while (n-- > 0) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            long result = 0;
            // 두 수의 최대 공약 수
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int min = Math.min(list.get(i), list.get(j));
                    int max = Math.max(list.get(i), list.get(j));

                    int gcd = 1;
                    HashSet<Integer> temp = new HashSet<>(); // 작은 수의 약수들

                    for (int k = 1; k * k <= min; k++) {
                        if (min % k == 0) {
                            temp.add(k);
                            temp.add(min / k);
                        }
                    }
                    for (int e : temp) {
                        if (max % e == 0) {
                            gcd = Math.max(gcd, e);
                        }
                    }
                    result += gcd;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}

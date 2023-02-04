import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P1269_대칭차집합 {
    public static void main(String[] args) throws IOException {
        // aset과 bset 설정
        // aset과 bset의 공집합 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashSet<Integer> aSet = new HashSet<>();
        HashSet<Integer> bSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }
        int cnt = 0;
        if (a > b) {
            Object[] arr = bSet.toArray();
            for (Object o : arr) {
                if (aSet.contains(o)) {
                    cnt++;
                }
            }
        } else {
            Object[] arr = aSet.toArray();
            for (Object o : arr) {
                if (bSet.contains(o)) {
                    cnt++;
                }
            }
        }
        System.out.println(a + b - (2 * cnt));
    }
}

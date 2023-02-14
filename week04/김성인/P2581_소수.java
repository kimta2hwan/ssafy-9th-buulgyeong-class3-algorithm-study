import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P2581_소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        ArrayList<Integer> pList = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            int cnt = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }
            if (cnt == 0 && i != 1) {
                pList.add(i);
            }
        }
        if (!pList.isEmpty()) {
            Collections.sort(pList);
            int sum = 0;
            for (int a : pList) {
                sum += a;
            }
            System.out.println(sum);
            System.out.println(pList.get(0));
        } else {
            System.out.println(-1);
        }
    }
}

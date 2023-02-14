import java.util.ArrayList;
import java.util.Scanner;

public class P2960_에라토스테네스의체 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            list.add(i);
        }
        while (!list.isEmpty()) {
            int num = list.get(0); // 가장 작은 수
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i : list) {
                if (i % num == 0) {
                    temp.add(i);
                    cnt++;
                    if (cnt == k) {
                        answer = i;
                        break;
                    }
                }
            }
            list.removeAll(temp);
            if (answer != 0) break;
        }
        System.out.println(answer);
    }
}

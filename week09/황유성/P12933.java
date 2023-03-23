import java.io.*;
import java.util.*;

public class P12933 {

    static char[] sound;
    static Map<Character, Integer> table = new HashMap<>();
    static int[] count = new int[5];

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sound = br.readLine().toCharArray();
    }

    static void solve() {
        table.put('q', 0);
        table.put('u', 1);
        table.put('a', 2);
        table.put('c', 3);
        table.put('k', 4);

        int answer = 0;
        for (char c : sound) {
            int idx = table.get(c);
            count[idx]++;
            if (idx == 0) answer = Math.max(answer, count[0] - count[4]);
            else {
                for (int i = 0; i < idx; i++) {
                    if (count[i] < count[idx]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        int tgt = count[0];
        for (int i = 1; i < 5; i++) {
            if (count[i] != tgt) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(answer);
    }
}

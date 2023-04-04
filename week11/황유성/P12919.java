import java.util.*;
import java.io.*;

public class P12919 {

    static char[] S, T;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine().toCharArray();
        T = br.readLine().toCharArray();
    }

    static void solve() {
        char[] end = Arrays.copyOf(S, S.length);
        char[] start = Arrays.copyOf(T, T.length);

        ArrayDeque<char[]> q = new ArrayDeque<>();
        q.offerLast(start);
        int len = T.length;
        while (len > S.length){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                char[] cur = q.pollFirst();
                if (cur[cur.length - 1] == 'A') {
                    char[] nex = Arrays.copyOfRange(cur, 0, cur.length - 1);
                    q.offerLast(nex);
                }
                if (cur[0] == 'B') {
                    char[] temp = Arrays.copyOfRange(cur, 1, cur.length);
                    char[] nex = new char[temp.length];
                    for (int j = 0; j < temp.length; j++) {
                        nex[j] = temp[temp.length - 1 - j];
                    }
                    q.offerLast(nex);
                }
            }
            len--;
        }

        String endStr = String.valueOf(end);
        while (!q.isEmpty()) {
            char[] cur = q.pollFirst();
            if (String.valueOf(cur).equals(endStr)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}

import java.io.*;
import java.util.*;

public class P15721 {

    static int A, T, target, cnt;
    static int[] repeat = {1, 1, 1, 1, 2, 2};

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
    }

    static void solve() {
        int pos = -1;
        int call = 0;
        while (true) {
            for (int r : repeat) {
                for (int i = 0; i < r; i++) {
                    if (++pos == A) pos = 0;
                    if (call == target && ++cnt == T) {
                        System.out.println(pos);
                        return;
                    }
                }
                call = 1 - call;
            }
            repeat[4]++;
            repeat[5]++;
        }
    }
}

import java.io.*;
import java.util.*;

public class P1802 {

    static boolean[] cw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            char[] inp = br.readLine().toCharArray();
            cw = new boolean[inp.length];
            for (int j = 0; j < inp.length; j++) {
                cw[j] = (inp[j] == '1');
            }

            sb.append(foldable() ? "YES\n" : "NO\n");
        }

        System.out.print(sb);
    }

    static boolean foldable() {
        return validate(0, cw.length - 1);
    }

    static boolean validate(int s, int e) {
        if (s == e) return true;

        int m = (s + e) >> 1;
        for (int i = s; i < m; i++) {
            if (cw[i] == cw[e - i]) return false;
        }
        return validate(s, m - 1) && validate(m + 1, e);
    }
}

import java.io.*;
import java.util.*;

public class P9342 {

    static char[] mid = {'A', 'F', 'C'};

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] inp = br.readLine().toCharArray();
            sb.append((check(inp) ? "Infected!\n" : "Good\n"));
        }
        System.out.print(sb);
    }

    static boolean check(char[] inp) {
        if (inp[0] - 'A' >= 6) return false;
        if (inp[inp.length - 1] - 'A' >= 6) return false;
        boolean[] chk = new boolean[26];
        chk[0] = inp[0] == 'A';
        chk[2] = inp[inp.length - 1] == 'C';
        int idx = 1;
        for (char c : mid) {
            while (idx < inp.length - 1 && inp[idx] == c) {
                chk[c - 'A'] = true;
                idx++;
            }
        }
        return (idx == inp.length - 1) && chk[0] && chk[5] && chk[2];
    }
}

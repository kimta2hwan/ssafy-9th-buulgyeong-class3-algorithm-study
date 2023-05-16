import java.io.*;
import java.util.*;

public class P6550 {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            char[] s = st.nextToken().toCharArray();
            char[] t = st.nextToken().toCharArray();
            sb.append(checkSubStr(s, t) ? "Yes\n" : "No\n");
        }
        System.out.print(sb);
    }

    static boolean checkSubStr(char[] s, char[] t) {
        int sIdx = 0;
        for (int tIdx = 0; tIdx < t.length; tIdx++) {
            if (s[sIdx] == t[tIdx]) {
                if (++sIdx == s.length) return true;
            }
        }
        return false;
    }
}

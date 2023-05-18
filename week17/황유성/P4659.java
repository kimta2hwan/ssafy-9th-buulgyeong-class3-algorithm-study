import java.io.*;

public class P4659 {

    static final boolean[] isNoun = new boolean[26];

    public static void main(String[] args) throws Exception {
        final char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (char c : vowels) {
            isNoun[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pw = null;
        while (!"end".equals(pw = br.readLine())) {
            boolean accept = true;
            char prev = pw.charAt(0);
            boolean vowelExist = isNoun[prev - 'a'];
            int cnt = 1;
            for (int i = 1; i < pw.length(); i++) {
                char cur = pw.charAt(i);
                if (isNoun[cur - 'a']) {
                    vowelExist = true;
                }
                if (cur != 'e' && cur != 'o' && cur == prev) {
                    accept = false;
                    break;
                }
                if (isNoun[prev - 'a'] == isNoun[cur - 'a']) {
                    if (++cnt == 3) {
                        accept = false;
                        break;
                    }
                } else {
                    cnt = 1;
                }
                prev = cur;
            }
            accept &= vowelExist;
            sb.append('<').append(pw).append("> is");
            if (!accept) sb.append(" not");
            sb.append(" acceptable.\n");
        }
        System.out.print(sb);
    }
}

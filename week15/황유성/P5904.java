import java.util.*;
import java.io.*;

public class P5904 {

    static int N;
    static ArrayList<Integer> S = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int curS = 0;
        int addition = 3;
        while (curS <= N) {
            curS = 2 * curS + (addition++);
            S.add(curS - 1);
        }

        System.out.println(getChar(S.size() - 1, N - 1));
    }

    static char getChar(int idx, int pos) {
        if (idx == 0) {
            return "moo".charAt(pos);
        }
        int prevS = S.get(idx - 1);
        int midLen = idx + 3;
        if (pos <= prevS) return getChar(idx - 1, pos);
        else if (pos <= prevS + midLen) return (pos == prevS + 1 ? 'm' : 'o');
        else return getChar(idx - 1, pos - prevS - midLen - 1);
    }
}

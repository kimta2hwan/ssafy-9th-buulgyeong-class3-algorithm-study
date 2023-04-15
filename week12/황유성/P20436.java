import java.io.*;
import java.util.*;

public class P20436 {

    static char[][] keyboard = {
        {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
        {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
        {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
    };

    static int[] yPos, xPos;
    static boolean[] isLeft;

    static char sl, sr;
    static char[] str;

    public static void main(String[] args) throws Exception {
        init();
        readInput();
        solve();
    }

    static void init() {
        yPos = new int[26];
        xPos = new int[26];
        isLeft = new boolean[26];
        for (int y = 0; y < keyboard.length; y++) {
            char[] line = keyboard[y];
            for (int x = 0; x < line.length; x++) {
                int idx = line[x] - 'a';
                yPos[idx] = y;
                xPos[idx] = x;
                isLeft[idx] = (x < 4 || x == 4 && y < 2);
            }
        }
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sl = st.nextToken().charAt(0);
        sr = st.nextToken().charAt(0);
        str = br.readLine().toCharArray();
    }

    static void solve() {
        int answer = str.length;
        for (char c : str) {
            if (isLeft[c - 'a']) {
                answer += cost(sl, c);
                sl = c;
            } else {
                answer += cost(sr, c);
                sr = c;
            }
        }
        System.out.println(answer);
    }

    static int cost(char cur, char next) {
        int cIdx = cur - 'a';
        int nIdx = next - 'a';
        return Math.abs(yPos[cIdx] - yPos[nIdx]) + Math.abs(xPos[cIdx] - xPos[nIdx]);
    }
}

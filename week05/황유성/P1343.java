import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1343 {

    static String board;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = br.readLine();
    }

    static void solve() {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        int size = board.length();
        while (i < size) {
            if (board.charAt(i) == '.') {
                answer.append('.');
                i++;
            } else if (board.substring(i, Math.min(i + 4, size)).equals("XXXX")) {
                answer.append("AAAA");
                i += 4;
            } else if (board.substring(i, Math.min(i + 2, size)).equals("XX")) {
                answer.append("BB");
                i += 2;
            } else {
                answer.replace(0, answer.length(), "-1");
                break;
            }
        }
        System.out.println(answer);
    }
}

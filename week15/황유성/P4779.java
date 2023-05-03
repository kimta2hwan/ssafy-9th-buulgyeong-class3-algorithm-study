import java.io.*;
import java.util.stream.Stream;

public class P4779 {

    static String[] cantor = new String[13];

    public static void main(String[] args) throws Exception {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stream<String> lines = br.lines();
        lines.forEach(line -> sb.append(cantor[Integer.parseInt(line)]).append('\n'));
        System.out.print(sb);
    }

    static void init() {
        String curLine = "-";
        for (int i = 0; i < 13; i++) {
            cantor[i] = curLine;
            StringBuilder sb = new StringBuilder();
            sb.append(curLine);
            for (int j = 0; j < curLine.length(); j++) {
                sb.append(' ');
            }
            sb.append(curLine);
            curLine = sb.toString();
        }
    }
}

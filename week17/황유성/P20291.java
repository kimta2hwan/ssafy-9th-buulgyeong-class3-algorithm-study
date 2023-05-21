import java.io.*;
import java.util.*;

public class P20291 {

    static int N;
    static TreeMap<String, Integer> table = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String ext = br.readLine().split("\\.")[1];
            if (table.containsKey(ext)) {
                table.put(ext, table.get(ext) + 1);
            } else {
                table.put(ext, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : table.entrySet()) {
            sb.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
        }
        System.out.print(sb);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String[] nameArr = new String[n];

        for (int i = 1; i < n + 1; i++) {
            String name = br.readLine();
            map.put(name, i);
            nameArr[i - 1] = name;
        }
        while (m-- > 0) {
            String word = br.readLine();
            if (isInteger(word)) {
                sb.append(nameArr[Integer.parseInt(word) - 1]);
            } else {
                sb.append(map.get(word));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
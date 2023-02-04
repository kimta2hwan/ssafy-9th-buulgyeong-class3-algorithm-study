import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P10546_배부른마라토너 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < (n * 2) - 1; i++) {
            String parti = br.readLine();
            if (map.containsKey(parti)) {
                map.put(parti, map.get(parti) + 1);
            } else {
                map.put(parti, 1);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                System.out.println(key);
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1302_베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            if (map.containsKey(book)) {
                map.put(book, map.get(book) + 1);
            } else {
                map.put(book, 1);
            }
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        int max = map.get(keySet.get(0));
        LinkedList<String> list = new LinkedList<>();
        for (String key : keySet) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}

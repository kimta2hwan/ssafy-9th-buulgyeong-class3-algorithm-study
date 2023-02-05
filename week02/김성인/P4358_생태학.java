import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class P4358_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String tree;
        int count = 0;
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        while ((tree = br.readLine()) != null) {
            if (treeMap.containsKey(tree)) {
                treeMap.put(tree, treeMap.get(tree) + 1);
            } else {
                treeMap.put(tree, 1);
            }
            count++;
        }
        for (String key : treeMap.keySet()) {
            System.out.printf("%s %.4f"+"\n", key, (double) (Math.round(((double) treeMap.get(key) / count)*100*10000))/10000);
        }
    }
}

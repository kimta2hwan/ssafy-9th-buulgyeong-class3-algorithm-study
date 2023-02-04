import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class P4358 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> trees = new HashMap<>();
        String tree;
        int count = 0;

        while ((tree = br.readLine()) != null && !tree.isEmpty()) {
            trees.put(tree, trees.getOrDefault(tree, 0) + 1);
            count++;
        }

        Object[] keys = trees.keySet().toArray();
        Arrays.sort(keys);

        StringBuilder sb = new StringBuilder();

        for (Object key : keys) {
            sb.append(key).append(' ').append(String.format("%.4f", (double) (trees.get((String) key) * 100) / count)).append('\n');
        }

        System.out.println(sb);
    }
}

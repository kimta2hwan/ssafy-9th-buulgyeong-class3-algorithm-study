import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P4358 {
	static int total = 0;
	static Map<String, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new HashMap<>();
		String treeNm;
		while ((treeNm = br.readLine()) != null) {
            total++;
            map.put(treeNm, map.getOrDefault(treeNm, 0) + 1);
        }
		
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		for(String tree: list) {
			System.out.println(tree + " " + String.format("%.4f", (double) map.get(tree) / total * 100));
		}

//		Object[] s = map.keySet().toArray();
//		Arrays.sort(s);
//
//		for (Object key : s) {
//			System.out.println((String) key + " " + String.format("%.4f", (double) map.get(key) / sum * 100));
//
//		}

	}

}
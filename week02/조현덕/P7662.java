import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P7662 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test = 0; test < T; test++) {

			// 우선순위 큐 2개 사용하는 것은 시간초과에 걸린다. remove에서 O(n)
			// treeMap을 사용하면 O(logN)
			int k = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> treemap = new TreeMap<>();

			StringTokenizer st;
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				if (st.nextToken().equals("I")) {
					int n = Integer.parseInt(st.nextToken());
					// key 안들어있으면 value 0, 들어있으면 +1
					treemap.put(n, treemap.getOrDefault(n, 0) + 1);
				} else {
					if (treemap.isEmpty()) {
						continue;
					}
					int n = Integer.parseInt(st.nextToken());
					if (n == 1) {
						// 최대값 삭제
						int key = treemap.lastKey();
						if (treemap.get(key) > 1) {
							treemap.put(key, treemap.get(key) - 1);
						} else {
							treemap.remove(key);
						}
					} else {
						// 최소값 삭제
						int key = treemap.firstKey();
						if (treemap.get(key) > 1) {
							treemap.put(key, treemap.get(key) - 1);
						} else {
							treemap.remove(key);
						}
					}
				}
			}
			if (treemap.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(treemap.lastKey() + " " + treemap.firstKey());
			}

		}
	}
}
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

// 참고 : https://dkswnkk.tistory.com/599
// 모든 노드에서 모든 거리를 다구하려고하니 터짐 
// 모두 연결된 그래프 -> 어느지점이든 가장먼노드는 일정(둘중하나)
// 한번 가장먼노드를 찾고 거기서 가장먼노드까지 거리를 구하면 된다.
public class BJ_1595_북쪽나라의도로 {
	static Integer[] nodes;
	static Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
	static Map<Integer, Boolean> check;
	static int maxDistance = 0;
	static int maxDistanceNode;
//		maxDistance, maxDistanceNode
//		bfs... accDistance -> max
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("1595.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Set<Integer> nodeSet = new HashSet<>();
		
		int lineCount=0;
		String line;
		while((line = br.readLine()) != null) {
			if(line.trim().length() <= 1) {
				break;
			}
			lineCount++;
			StringTokenizer st = new StringTokenizer(line);
			int nodeFrom = Integer.parseInt(st.nextToken());
			int nodeTo = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
//			From, To 각각 서로서로 넣어주기
			nodeSet.add(nodeFrom);
			nodeSet.add(nodeTo);
			if(graph.containsKey(nodeFrom)) {
				graph.get(nodeFrom).put(nodeTo, distance);
			}else {
				Map<Integer, Integer> map = new HashMap<>();
				map.put(nodeTo, distance);
				graph.put(nodeFrom, map);				
			}
			
			if(graph.containsKey(nodeTo)) {
				graph.get(nodeTo).put(nodeFrom, distance);
			}else {
				Map<Integer, Integer> map = new HashMap<>();
				map.put(nodeFrom, distance);
				graph.put(nodeTo, map);	
			}
		}
		if(lineCount == 0) {
			System.out.println(0);
			return;
		}
		
		nodes = new Integer[nodeSet.size()];
		nodeSet.toArray(nodes);

		check = new HashMap<>();
		for (Integer n : nodes) {
			check.put(n, false);
		}
		check.put(nodes[0], true);
		dfs(nodes[0], 0);
		
		for (Integer n : nodes) {
			check.put(n, false);
		}
		dfs(maxDistanceNode, 0);
		
		System.out.println(maxDistance);
		
	}
	public static void dfs(int node, int acc) {
		
		if(acc > maxDistance) {
			maxDistance = acc;
			maxDistanceNode = node;
		}
		// Map에서 key, value를 모두 사용하는 방법 중 iterator를 활용
		Map<Integer,Integer> linkedNodes = graph.get(node);
		Iterator<Entry<Integer, Integer>> iterator = linkedNodes.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Integer, Integer> entry = iterator.next();
			int nextNode = entry.getKey();
			int distance = entry.getValue();
			if(check.get(nextNode))continue;
			check.put(nextNode, true);
			dfs(nextNode, acc + distance);
		}
		
	}

}

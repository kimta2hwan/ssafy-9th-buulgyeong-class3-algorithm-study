import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class BJ_1967_트리의지름 {
	static Map<Integer, Integer>[] graph;
	static boolean[] check;
	static int maxWeight = 0;
	static int maxWeightNode = 1;
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("BJ_1967_트리의지름.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int nodeCount = Integer.parseInt(br.readLine());
		if(nodeCount == 1) {
			System.out.println(0);
			return;
		}
		graph = new HashMap[nodeCount+1];
		
		for (int i = 0; i < nodeCount-1; i++) {
			String[] splitted = br.readLine().split(" ");
			int nodeFrom = Integer.parseInt(splitted[0]);
			int nodeTo = Integer.parseInt(splitted[1]);
			int weight = Integer.parseInt(splitted[2]);
			
			if(graph[nodeFrom] == null) {
				graph[nodeFrom] = new HashMap<Integer, Integer>();
			}
			if(graph[nodeTo] ==null) {
				graph[nodeTo]= new HashMap<Integer, Integer>();
			}
			graph[nodeTo].put(nodeFrom, weight);
			graph[nodeFrom].put(nodeTo, weight);
		}
		check = new boolean[nodeCount + 1];
		dfs(1, 0);
		
		maxWeight = 0;
		check = new boolean[nodeCount + 1];
		dfs(maxWeightNode, 0);
		
		System.out.println(maxWeight);
	}
	
	public static void dfs(int node, int accWeight) {
//		시작 노드를 true 처리하기 위함. 이것때문에 틀렸었음.
		check[node] = true;
		
		if(accWeight > maxWeight) {
			maxWeight = accWeight;
			maxWeightNode = node;
		}
		
		Iterator<Entry<Integer, Integer>> linkedNodesItr = graph[node].entrySet().iterator();
		while(linkedNodesItr.hasNext()) {
			Entry<Integer, Integer> entry = linkedNodesItr.next();
			int nextNode = entry.getKey();
			int weight = entry.getValue();
			
//			아직 탐색하지 않은 노드라면 재귀호출
			if(!check[nextNode]) {
				check[nextNode] = true;
				dfs(nextNode, accWeight + weight);
			}
		}
	}

}

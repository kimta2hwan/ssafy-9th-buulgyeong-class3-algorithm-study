import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BJ_3584_가장가까운공통조상 {
	static Node[] nodes;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BJ_3584_가장가까운공통조상.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCaseCount = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= testCaseCount; i++) {
			int nodeCount = Integer.parseInt(br.readLine());
//			노드 초기화
			nodes = new Node[nodeCount+1];
			check = new boolean[nodeCount + 1];
			for (int j = 1; j <= nodeCount; j++) {
				nodes[j] = new Node(j);
			}
			
//			트리 부모-자식 관계 할당
			for (int j = 0; j < nodeCount-1; j++) {
				String[] splitted = br.readLine().split(" ");
				int parentIdx = Integer.parseInt(splitted[0]);
				int childIdx = Integer.parseInt(splitted[1]);
				
				nodes[parentIdx].children.add(nodes[childIdx]);
				nodes[childIdx].parent = nodes[parentIdx];
			}
			String[] splitted = br.readLine().split(" ");
			
			
			Node node1 = new Node(-1);
			Node node2 = new Node(-1);
			
//			주의! : 자기자신도 조상에 포함된다. -> 새로운 노드를 만들고 parent를 목표노드로 설정
			node1.parent = nodes[Integer.parseInt(splitted[0])];
			node2.parent = nodes[Integer.parseInt(splitted[1])];
					
			int ancestor = 0;
			while(node1.parent != null) {
				check[node1.parent.value] = true;
				node1 = node1.parent;
			}
//			node1의 부모인(이미 지나간) 노드를 만나면 그것이 공통조상이다
			while(node2.parent != null) {
				if(check[node2.parent.value]) {
					ancestor = node2.parent.value;
					break;
				}
				node2 = node2.parent;
			}
			
			System.out.println(ancestor);
			
		}
	}

	static class Node{
		int value;
		Node parent;
		ArrayDeque<Node> children;
		
		Node(int value){
			this.value = value;
			this.children = new ArrayDeque<>();
		}
	}
}

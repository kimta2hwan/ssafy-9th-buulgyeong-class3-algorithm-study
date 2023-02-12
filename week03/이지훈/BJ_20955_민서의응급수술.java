import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ_20955_민서의응급수술 {
	static int[] parents;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("BJ_20955.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		int cycleCount = 0;

		int nodeCount = Integer.parseInt(line[0]);
		int edgeCount = Integer.parseInt(line[1]);

		parents = new int[nodeCount + 1]; // 1번부터 시작하니 0~nodeCount까지 모두담도록 +1
//		처음엔 자기자신을 가리키도록
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

//		엣지 연결 입력
		for (int i = 0; i < edgeCount; i++) {
			line = br.readLine().split(" ");
			int node1 = Integer.parseInt(line[0]);
			int node2 = Integer.parseInt(line[1]);
			if (!union(node1, node2)) {
				cycleCount++;
			}
		}

    // 부모가 같은 그룹들의 갯수 -1 (그룹 연결 횟수) + 사이클을 끊는 횟수
		Set<Integer> group = new HashSet<>();
		for (int i = 1; i <= nodeCount; i++) {
			group.add(find(i));
		}
		System.out.println(group.size() - 1 + cycleCount);

	}

	public static boolean union(int node1, int node2) {
		int parent1 = find(node1);
		int parent2 = find(node2);

		if (parent1 == parent2)
			return false;

		int minParent = Math.min(parent1, parent2);
		parents[parent1] = minParent;
		parents[parent2] = minParent;
		return true;
	}

//	그룹 갯수를 세기 위해서 찾으며 부모를 최신화시켜줘야한다.
	public static int find(int node) {
		if (node == parents[node])
			return node;
		return parents[node] = find(parents[node]);
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P6416 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// test case 반복/ 음수, 음수 나오면 종료
		int test_case = 1;
		while (true) {
			// tree 판별 기준
			// 1. root가 1개
			// 2. root제외하고 진입 간선 1개
			// 3. 정점의 개수 - 1 == 간선의 개수
			// 정점, 진입 간선의 개수
			Map<Integer, Integer> map = new HashMap<>();

			boolean test_case_end = false;
			int edge = 0; // 간선의 수

			// 0, 0을 받을 때까지 반복
			while (true) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				while (st.hasMoreTokens()) {
					int start = Integer.parseInt(st.nextToken());
					int end = Integer.parseInt(st.nextToken());
					if (start < 0 && end < 0) {
						test_case_end = true;
					}

					map.put(start, map.getOrDefault(start, 0));
					map.put(end, map.getOrDefault(end, 0) + 1); // 진입간선의 개수
					edge++;
				}

				if (map.containsKey(0)) {
					// 0넣었던거 다시 빼줘야함
					map.remove(0);
					edge--;
					break;
				}

				if (test_case_end) {
					return;
				}

			}

			// root노드가 1개 있는지 확인 변수
			int root = 0;
			// 진입 간선의 개수가 2개 이상이면 tree가 아닌걸 확인하는 변수
			boolean isTree = true;
			for (int key : map.keySet()) {
				if (map.get(key) == 0)
					root++;
				if (map.get(key) > 1) {
					isTree = false;
					break;
				}
			}

			// 아무것도 없어도 tree로 인정
			if (map.size() == 0) {
				System.out.printf("Case %d is a tree.\n", test_case);
			} else if (isTree && root == 1 && edge == map.size() - 1) {
				System.out.printf("Case %d is a tree.\n", test_case);
			} else {
				System.out.printf("Case %d is not a tree.\n", test_case);
			}
			test_case++;
		}

	}
}

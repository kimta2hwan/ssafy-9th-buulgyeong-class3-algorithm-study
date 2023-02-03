import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class P21939 {
	static TreeSet<int[]> list; // 정렬용 tree set
	static Map<Integer, Integer> map; // 문제 번호로 난이도 찾기 용 map

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 난이도로 낮은거부터 높은순, 같으면 문제번호 낮은거부터 높은순 정렬
		list = new TreeSet<>((a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			} else {
				return a[1] - b[1];
			}
		});
		map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			list.add(new int[] {L, P});
			map.put(P, L);
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("recommend")) {
				int x = Integer.parseInt(st.nextToken());
				// 1이면 가장 어려운것 출력, 중복이면 문제번호 큰것
				// -1이면 가장 쉬운것 출력, 중복이면 문제번호 작은것
				if (x == 1) {
					int[] prob = list.last();
					sb.append(prob[1]).append("\n");
				}else {
					int[] prob = list.first();
					sb.append(prob[1]).append("\n");
				}
			} else if (command.equals("add")) {
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				list.add(new int[] {L, P});
				map.put(P, L);
			} else {
				int prob = Integer.parseInt(st.nextToken());
				int level = map.get(prob);
				list.remove(new int[] {level, prob});
				map.remove(prob);
			}
		}
		System.out.println(sb);

	}
}

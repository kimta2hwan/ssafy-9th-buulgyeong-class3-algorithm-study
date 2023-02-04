import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class P21942 {
	// 부품과 빌려간 사람이름을 key로 빌린시간 value를 찾는다
	static Map<Info, String> map;
	// 벌금낼 사람과 벌금액
	static Map<String, Long> result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 작성된 정보의 개수
		String[] Ls = st.nextToken().split("[/:]"); // 대여기간 DDD/hh:mm, /와 :로 나눔
		// 대여기간을 분으로 변환
		int L = Integer.parseInt(Ls[0]) * 24 * 60 + Integer.parseInt(Ls[1]) * 60 + Integer.parseInt(Ls[2]);
		int F = Integer.parseInt(st.nextToken()); // 1분당 벌금

		map = new HashMap<>();
		result = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String date = st.nextToken();
			String time = st.nextToken();
			String partsNm = st.nextToken();
			String name = st.nextToken();
			Info info = new Info(partsNm, name);

			// map에 부품, 이름 들어있는 경우
			if (map.containsKey(info)) {
				// LocalDateTime에 넣기 위해서 format을 만듬
				DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime dateTime1 = LocalDateTime.parse(map.get(info), f);
				LocalDateTime dateTime2 = LocalDateTime.parse(date + " " + time, f);
				// 차이를 분으로 나타냄
				long diff = dateTime1.until(dateTime2, ChronoUnit.MINUTES);
				if (diff > L) {
					long fine = (diff - L) * F;
					result.put(name, result.getOrDefault(name, (long) 0) + fine);
				}
				// 반납을 했으므로 map에서 삭제 필요
				map.remove(info);
			} else {
				// 없는 경우
				map.put(info, date + " " + time);
			}

		}
		StringBuilder sb = new StringBuilder();
		// 이름 사전 순으로 출력, 없으면 -1
		List<String> list = new ArrayList<>(result.keySet());
		Collections.sort(list);
		if (list.size() == 0) {
			System.out.println(-1);
		} else {
			for (String name : list) {
				sb.append(name + " " + result.get(name) + "\n");
			}
		}
		System.out.println(sb);
	}

	static class Info {
		String partsNm;
		String name;

		public Info(String partsNm, String name) {
			this.partsNm = partsNm;
			this.name = name;
		}

		@Override
		public int hashCode() {
			return Objects.hash(partsNm, name);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Info) {
				Info info = (Info) obj;
				if (this.partsNm.equals(info.partsNm) && this.name.equals(info.name)) {
					return true;
				}
			}
			return false;
		}

	}
}
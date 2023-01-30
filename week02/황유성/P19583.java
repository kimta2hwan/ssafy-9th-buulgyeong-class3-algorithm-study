import java.io.*;
import java.util.*;

/**
 * 1. 입장 확인 : 채팅 기록 시간 <= 개총 시작 시간
 * 2. 퇴장 확인 : 개총 종료 시간 <= 채팅 기록 시간 <= 스트리밍 종료 시간
 * 3. 시간을 정수로 변환하기 위해 StringTokenizer를 사용하는 것보다는 substring 메소드를 이용하는 것이 간결하겠다
 * 4. 입장 인원 집합, 퇴장 인원 집합을 구해서 교집합 연산을 하면 정답을 얻을 수 있겠다
 * 5. 집합의 구현 클래스로는 기본 연산이 O(logN)인 TreeSet 대신 O(1)인 HashSet을 사용하자.
 */

public class P19583 {
    public static void main(String[] args) throws IOException {
        int s, e, q;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = strToInt(st.nextToken());
        e = strToInt(st.nextToken());
        q = strToInt(st.nextToken());

        Set<String> enterSet = new HashSet<>();
        Set<String> quitSet = new HashSet<>();
        while (br.ready()) {
            st = new StringTokenizer(br.readLine());
            int time = strToInt(st.nextToken());
            String name = st.nextToken();
            if (time <= s) {
                enterSet.add(name);
            } else if (e <= time && time <= q) {
                quitSet.add(name);
            }
        }
        enterSet.retainAll(quitSet);

        System.out.println(enterSet.size());
    }

    static int strToInt(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));
        return 60 * h + m;
    }
}

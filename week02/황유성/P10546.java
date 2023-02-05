import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 참가자들 중에 동명이인이 있을 수 있으므로, 이름마다 개수를 HashMap으로 관리하자.
 * 2. Map에서 하나의 key값을 간단히 출력하는 방법이 없을까?
 */

public class P10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.putIfAbsent(name, 0);
            map.compute(name, (k, v) -> v + 1);
        }
        for (int i = 1; i < N; i++) {
            String name = br.readLine();
            map.compute(name, (k, v) -> (v == 1 ? null : v - 1));
            // compute 메서드는, 새로 할당할 value가 null이면 해당 key를 Map에서 제거한다
        }
        System.out.println(map.keySet().iterator().next());
    }
}

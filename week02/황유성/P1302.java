import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1. Map의 구현체로 TreeMap을 사용하면, iteration을 할 때, key값의 사전 순으로 확인한다.
 * 2. 따라서 정답을 찾기 위한 기준에 (책 개수, 제목의 사전 순) 두 가지를 넣을 필요 없이, 책 개수만 따지면 된다.
 */

public class P1302 {
    static Map<String, Integer> cntMap = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        readInput();
        solve();
    }
    static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            cntMap.putIfAbsent(title, 0);
            cntMap.compute(title, (k, v) -> v + 1);
        }
    }
    static void solve() {
        String answer = null;
        Integer ansCnt = 0;
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() > ansCnt) {
                answer = entry.getKey();
                ansCnt = entry.getValue();
            }
        }
        System.out.println(answer);
    }
}

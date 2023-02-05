import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1. 종의 이름을 key값으로 받는 Map 인터페이스를 사용하자.
 * 1. key값의 정렬 상태를 유지해주는 TreeMap을 구현체로 사용하자.
 */
public class P4358 {
    static Map<String, Integer> cntMap = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        readInput();
        solve();
    }
    static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String name = br.readLine();
            if (name == null) break;
            cntMap.putIfAbsent(name, 0);
            cntMap.computeIfPresent(name, (k, v) -> v + 1);
        }
        br.close();
    }
    static void solve() throws IOException {
        int treeCnt = 0;
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            treeCnt += entry.getValue();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            bw.write(entry.getKey() + String.format(" %.4f\n", (float) (entry.getValue() * 100) / treeCnt));
        }
        bw.flush();
        bw.close();
    }
}

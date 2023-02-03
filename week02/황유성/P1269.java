import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 원소의 값이 1억을 넘으므로 boolean 배열을 통해 방문 처리하면 시간을 초과한다
 * 2. 원소 탐색의 시간 복잡도가 O(1)인 집합을 사용하자.
 * 3. 교집합 연산의 시간 복잡도가 O(N)이므로 이를 이용하자.
 */
public class P1269 {
    static int aLen, bLen;
    static Set<Integer> setA, setB;
    public static void main(String[] args) throws IOException {
        readInput();
        solve();
    }
    static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        aLen = Integer.parseInt(st.nextToken());
        bLen = Integer.parseInt(st.nextToken());
        setA = new HashSet<>(aLen); // 해쉬 테이블의 크기(capacity)를 미리 지정하여, 무의미한 수준이지만 add 연산의 성능을 높이자
        setB = new HashSet<>(bLen);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aLen; i++) {
            setA.add(Integer.valueOf(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bLen; i++) {
            setB.add(Integer.valueOf(st.nextToken()));
        }
    }
    static void solve() {
        Set<Integer> intersect = new HashSet<>(aLen);
        intersect.addAll(setA);
        intersect.retainAll(setB);
        setA.removeAll(intersect);
        setB.removeAll(intersect);
        System.out.println(setA.size() + setB.size());
    }
}

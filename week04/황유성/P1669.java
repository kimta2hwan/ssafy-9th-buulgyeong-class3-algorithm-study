import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 도달 가능한 노드의 개수가 2^31이므로 다익스트라는 쓸 수 없겠다
 * 2. 9cm를 늘리기 위해 1 2 3 2 1 보다 더 빠른 방법은 존재하지 않는다
 * 3. 10cm를 늘린다 하면 1 1 2 3 2 1 (ans = 6) k = 3
 * 4. 11cm를 늘린다 하면 1 2 2 3 2 1
 * 5. 12cm를 늘린다 하면 1 2 3 3 2 1
 * 6. 13cm를 늘린다 하면 1 1 2 3 3 2 1 (ans = 7) k = 3
 * 7. 14cm를 늘린다 하면 1 2 2 3 3 2 1
 * 8. 15cm를 늘린다 하면 1 2 3 3 3 2 1
 * 9. 16cm를 늘린다 하면 1 2 3 4 3 2 1
 * 10. 17cm를 늘린다 하면 1 1 2 3 4 3 2 1 (ans = 8) k = 4
 * ...
 * 즉 d = y - x 라고 할 때
 * S(2k - 1) + k = k^2 < d 를 만족하는 최대한의 k를 찾자
 * k = ceil(sqrt(d)) - 1
 * 만약 k(k + 1) >= d 이면 answer = 2k
 * 그렇지 않다면 answer = 2k + 1
 */

public class P1669 {
    static int X, Y;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        int d = Y - X;
        if (d == 0) {
            System.out.println(0);
            return;
        }
        int k = (int)Math.ceil(Math.sqrt(d)) - 1;
        int answer = (k * (k + 1) >= d) ? (2 * k) : (2 * k + 1);
        System.out.println(answer);
    }
}

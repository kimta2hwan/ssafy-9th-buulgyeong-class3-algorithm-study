import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1 2 2 1
 * 0 1 2 3
 *
 * 1 -> 1 + 0 + 2 + 2 = 5
 * 1.5 -> 1.5 + 1 + 1 + 1.5 = 5
 *
 *
 * 1 3 2 1
 * 0 1 2 3
 *
 * 1 -> 5
 * 1.5 -> 1.5 + 1.5 + 1 + 1.5 = 5.5
 *
 *
 * 1 2 3 4
 * 0 1 2 3
 *
 * 1.5 -> 1.5 + 1 + 1.5 + 6 = 10
 * 2 -> 2 + 2 + 0 + 4 = 8
 * 2.25 -> 2.25 + 2.5 + 0.75 + 3 = 8.5
 * 2.5 -> 2.5 + 3 + 1.5 + 2 = 9
 * 3 -> 3 + 4 + 3 + 0 = 10
 *
 *
 * 1 2 3 4
 * 0 1 2 10
 *
 * 2 -> 2 + 2 + 0 + 32 = 36
 * 3 -> 3 + 4 + 3 + 28 = 38
 * 10 -> 10 + 18 + 24 = 52
 *
 *
 * 1. 우체국의 최적 위치는 해당 위치를 기준으로 양쪽의 인원 수가 균형을 이룰수록 최적이다
 *    - 균형에서 벗어날수록, 즉 양쪽의 인원 수 차이가 커질수록 거리 합에 많이 가중된다
 * 2. 마을 중 한 곳에 우체국을 짓는 것이 최적이다
 *    - 양쪽의 인원 수를 줄이는 효과가 있기 때문이다 => 마을이 아닌 중간 지점에 짓는 것이 이득일 수는 없다
 * 따라서 좌표값은 고려하지 않아도 된다. 단지 각 마을들이 일직선상에 어떤 순서로 위치되어 있는지만 고려하면 된다.
 */


public class P2141 {

    static int N;
    static Village[] villages;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        villages = new Village[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            villages[i] = new Village(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    static void solve() {
        Arrays.sort(villages);

        long leftNum = 0;
        long rightNum = 0;
        for (Village v : villages) {
            rightNum += v.a;
        }

        long minDiff = Long.MAX_VALUE;
        int answer = Integer.MAX_VALUE;
        for (Village v : villages) {
            rightNum -= v.a;
            long curDiff = Math.abs(leftNum - rightNum);
            leftNum += v.a;
            if (curDiff < minDiff) {
                minDiff = curDiff;
                answer = v.x;
            }
        }
        System.out.println(answer);
    }

    static class Village implements Comparable<Village> {
        int x, a;
        Village(int x, int a) {
            this.x = x;
            this.a = a;
        }

        @Override
        public int compareTo(Village o) {
            return this.x - o.x;
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 한 마리의 벌과 꿀통은 무조건 양끝에 위치시키는 것이 최적이다.
 * 2. 이때 양끝 중 꿀의 양이 적은 곳에 벌을 위치시킨다.(x) -> 두 가지 경우 다 해 봐야 한다.
 * 3. 나머지 한 마리의 벌의 최적 위치는 꿀통에서 시작하는 누적합을 계산하여 찾는다.
 * 4. 예제3) 두 마리의 벌을 양끝에 위치시키고 꿀통의 최적 위치를 중간에서 찾는 작업도 해야 한다
 */
public class P21758 {

    static int N;
    static int[] honey, prefSum;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        honey = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int answer1 = 0;
        for (int k = 0; k < 2; k++) {
            prefSum = new int[N];
            prefSum[0] = honey[0];
            for (int i = 1; i < N; i++) {
                prefSum[i] = prefSum[i - 1] + honey[i];
            }

            for (int i = 1; i < N - 1; i++) {
                answer1 = Math.max(answer1, prefSum[i] - 2 * honey[i] + prefSum[N - 2]);
            }

            if (k == 0) {
                int[] revHoney = new int[N];
                for (int i = 0; i < N; i++) {
                    revHoney[i] = honey[N - 1 - i];
                }
                honey = revHoney;
            }
        }

        int answer2 = 0;
        for (int i = 1; i < N - 1; i++) {
            answer2 = Math.max(answer2, honey[i]); // try 1) WA. 최솟값을 찾는 오류 수정
        }
        answer2 += prefSum[N - 2] - prefSum[0];

        System.out.println(Math.max(answer1, answer2));
    }
}

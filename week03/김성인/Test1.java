import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1 {
    static boolean[] switchArray;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine()); // 스위치 수
        switchArray = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            // 1. 스위치 상태를 담는 배열 (static)
            int a = Integer.parseInt(st.nextToken());
            switchArray[i] = a == 1;
        }
        int m = Integer.parseInt(br.readLine());
        // 2. 학생 수만큼 반복
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // 2-1. 첫 수 보고 male female 함수 고르기
            if (Integer.parseInt(st.nextToken()) == 1) {
                male(Integer.parseInt(st.nextToken()));
            } else {
                female(Integer.parseInt(st.nextToken()));
            }
        }
        int cnt = 0;
        for (boolean isTurn : switchArray) {
            int result = isTurn ? 1 : 0;
            sb.append(result);
            cnt++;
            if (cnt % 20 == 0) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }
        System.out.print(sb);
    }

    static void male(int num) {
        for (int i = num; i < n; i += num) {
            switchArray[i - 1] = !switchArray[i - 1];
        }
    }

    static void female(int num) {
        num--;
        // num이 1보다 작아지면 안되고 n보다 커지면 안된다.
        int start = num - 1, end = num + 1;
        while (0 <= start && end < n) {
            if (switchArray[start] != switchArray[end]) break;
            start--;
            end++;
        }
        start++;
        end--;
        for (int i = start; i <= end; i++) {
            switchArray[i] = !switchArray[i];
        }
    }
}

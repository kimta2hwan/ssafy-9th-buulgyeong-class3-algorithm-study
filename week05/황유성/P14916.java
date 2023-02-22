import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P14916 {

    static int N;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    static void solve() {
        int answer = 0;
        if (N < 10 && N % 2 == 0) { // try 1, 2) WA. 반례) N = 2, N = 6
            System.out.println(N / 2);
            return;
        }
        for (int i = 0; i < 5 && N > 0; i++) {
            if (N % 5 == 0) {
                answer += N / 5;
                System.out.println(answer);
                return;
            }
            answer++;
            N -= 2;
        }
        System.out.println(-1);
    }
}

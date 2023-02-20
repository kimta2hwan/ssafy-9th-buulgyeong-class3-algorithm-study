import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.LongStream;

public class P2745 {

    static char[] N;
    static int B;
    static long weight;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = st.nextToken().toCharArray();
        B = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        int[] arr = new int[N.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (N[i] <= '9' ? N[i] - '0' : N[i] - 'A' + 10);
        }
        weight = LongStream.generate(() -> B).limit(N.length).reduce(1, (a, b) -> a * b); // try 1, 2, 3) WA. pow 결과의 정수 변환 시 오차, 그리고 오버플로우
        int answer = Arrays.stream(arr).reduce(0, (prev, cur) -> prev + decode(cur));
        System.out.println(answer);
    }

    static int decode(int i) {
        weight /= B;
        return i * (int)weight;
    }
}

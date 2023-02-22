import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2217 {

    static int N;
    static int[] capacity;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        capacity = new int[N];
        for (int i = 0; i < N; i++) {
            capacity[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        Arrays.sort(capacity);

        int maxWeight = 0;
        for (int i = 0; i < N; i++) {
            maxWeight = Math.max(maxWeight, capacity[i] * (N - i));
        }

        System.out.println(maxWeight);
    }
}

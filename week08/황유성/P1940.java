import java.io.*;
import java.util.*;

public class P1940 {

    static int N, M;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        Arrays.sort(nums);

        int rp = -1;
        for (int i = 1; i < N; i++) {
            if (nums[i - 1] + nums[i] <= M) {
                rp = i;
            }
        }

        int answer = 0;
        int lp = rp - 1;
        while (0 <= lp && rp < N) {
            int sum = nums[lp] + nums[rp];
            if (sum > M) {
                lp--;
            } else {
                if (sum == M) answer++;
                rp++;
            }
        }

        System.out.println(answer);
    }
}

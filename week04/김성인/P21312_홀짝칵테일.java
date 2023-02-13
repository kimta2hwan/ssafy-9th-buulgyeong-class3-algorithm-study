import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21312_홀짝칵테일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int best = 1;
        int oddCnt = 0;
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for (int num : nums) {
            if (num % 2 == 1) {
                best *= num;
                oddCnt++;
            }
        }
        if (oddCnt == 0) {
            for (int num : nums) {
                best *= num;
            }
        }
        System.out.println(best);
    }
}

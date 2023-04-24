import java.io.*;
import java.util.*;

public class P15665 {

    static int N, M;
    static int[] nums, tgt;
    static HashSet<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        tgt = new int[M];
        perm(0);

        System.out.print(sb);
    }

    static void perm(int tgtIdx) {
        if (tgtIdx == M) {
            String cur = Arrays.toString(tgt);
            if (!set.contains(cur)) {
                for (int num : tgt) {
                    sb.append(num).append(' ');
                }
                sb.append('\n');

                set.add(cur);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            tgt[tgtIdx] = nums[i];
            perm(tgtIdx + 1);
        }
    }
}

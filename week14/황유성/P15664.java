import java.io.*;
import java.util.*;

public class P15664 {

    static int N, M;
    static int[] src, tgt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        src = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(src);

        tgt = new int[M];

        comb(0, 0);
        System.out.print(sb);
    }

    static void comb(int tgtIdx, int start) {
        if (tgtIdx == M) {
            for (int num : tgt) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = 0;
        for (int i = start; i < N; i++) {
            int cur = src[i];
            if (cur == prev) continue;
            tgt[tgtIdx] = cur;
            comb(tgtIdx + 1, i + 1);
            prev = cur;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2798_블랙잭 {
    static int[] ints;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ints = new int[n];

        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0, 0);

        System.out.println(result);
    }


    static int result = Integer.MAX_VALUE;

    static void comb(int srcIdx, int tgtIdx, int temp) {
        if (temp > m) return;

        if (tgtIdx == 3) {
            if (Math.abs(result - m) > Math.abs(temp - m)) result = temp;
            return;
        }

        if (srcIdx == ints.length) return;

        temp += ints[srcIdx];
        comb(srcIdx + 1, tgtIdx + 1, temp);

        temp -= ints[srcIdx];
        comb(srcIdx + 1, tgtIdx, temp);
    }
}

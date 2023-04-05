import java.util.*;
import java.io.*;

public class P9079 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int initShape, answer;
    static final int ALL_T = 0, ALL_H = (1 << 9) - 1;
    static int[] src = {
            1 << 0 | 1 << 1 | 1 << 2,
            1 << 3 | 1 << 4 | 1 << 5,
            1 << 6 | 1 << 7 | 1 << 8,
            1 << 0 | 1 << 3 | 1 << 6,
            1 << 1 | 1 << 4 | 1 << 7,
            1 << 2 | 1 << 5 | 1 << 8,
            1 << 0 | 1 << 4 | 1 << 8,
            1 << 2 | 1 << 4 | 1 << 6
    };

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            readTestCase();
            solve();
        }
    }

    static void readTestCase() throws Exception {
        initShape = 0;
        int pos = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                if (st.nextToken().charAt(0) == 'H') {
                    initShape |= 1 << pos;
                }
                pos++;
            }
        }
    }

    static void solve() {
        answer = Integer.MAX_VALUE;

        subset(0, initShape, 0);

        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

    static void subset(int depth, int shape, int oprCnt) {
        if (shape == ALL_T || shape == ALL_H) answer = Math.min(answer, oprCnt);
        if (depth == src.length) return;
        if (oprCnt >= answer) return;

        subset(depth + 1, shape ^ src[depth], oprCnt + 1);
        subset(depth + 1, shape, oprCnt);
    }

}

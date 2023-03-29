import java.util.*;
import java.io.*;

public class P21941 {

    static char[] S;
    static int M;
    static char[][] A;
    static int[] score;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine().toCharArray();
        M = Integer.parseInt(br.readLine());
        A = new char[M][];
        score = new int[M];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = st.nextToken().toCharArray();
            score[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int[] dp = new int[S.length + 1];
        for (int i = 1; i <= S.length; i++) {
            dp[i] = dp[i - 1] + 1;

            for (int j = 0; j < M; j++) {
                if (i < A[j].length) continue;
                char[] cur = A[j];

                int p = i - cur.length;
                int q = 0;
                boolean match = true;
                for (; q < cur.length; p++, q++) {
                    if (S[p] != cur[q]) {
                        match = false;
                        break;
                    }
                }

                if (match) dp[i] = Math.max(dp[i], dp[i - cur.length] + score[j]);
            }
        }
        System.out.println(dp[S.length]);
    }
}

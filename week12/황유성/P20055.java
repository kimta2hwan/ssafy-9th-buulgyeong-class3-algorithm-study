import java.io.*;
import java.util.*;

public class P20055 {

    static int N, K;
    static int[] A;
    static boolean[] occupied;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[2 * N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        final int MOD = 2 * N;
        int loadPos = 0;
        int unloadPos = N - 1;
        int stageCnt = 0;
        occupied = new boolean[A.length];

        while (K > 0) {
            stageCnt++;
            loadPos = (loadPos + MOD - 1) % MOD;
            unloadPos = (unloadPos + MOD - 1) % MOD;

            if (occupied[unloadPos]) {
                occupied[unloadPos] = false;
            }

            int cur = (unloadPos + MOD - 1) % MOD;
            if (occupied[cur] && A[unloadPos] != 0) {
                occupied[cur] = false;
                if (--A[unloadPos] == 0) K--;
            }
            int prev = cur;
            for (int i = 3; i < N; i++) {
                cur = (prev + MOD - 1) % MOD;
                if (occupied[cur] && !occupied[prev] && A[prev] != 0) {
                    occupied[cur] = false;
                    occupied[prev] = true;
                    if (--A[prev] == 0) K--;
                }
                prev = cur;
            }
            if (A[loadPos] != 0) {
                occupied[loadPos] = true;
                if (--A[loadPos] == 0) K--;
            }
        }
        System.out.println(stageCnt);
    }
}

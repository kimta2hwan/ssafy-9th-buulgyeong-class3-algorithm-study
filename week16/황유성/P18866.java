import java.util.*;
import java.io.*;

public class P18866 {
    static final int INF = 1_000_000_000;
    static int N;
    static int[] u, v, pu, pv, su, sv;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        u = new int[N + 1];
        v = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            u[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        pu = new int[N + 2];
        pv = new int[N + 2];
        su = new int[N + 2];
        sv = new int[N + 2];
        pu[0] = INF;
        sv[N + 1] = INF;
        for (int i = 1; i <= N; i++) {
            pu[i] = Math.min(pu[i - 1], u[i] == 0 ? INF : u[i]);
            pv[i] = Math.max(pv[i - 1], v[i]);
        }
        for (int i = N; i >= 1; i--) {
            su[i] = Math.max(su[i + 1], u[i]);
            sv[i] = Math.min(sv[i + 1], v[i] == 0 ? INF : v[i]);
        }

        int K = -1;
        for (int i = 1; i < N; i++) {
            if (pu[i] < su[i + 1] || pv[i] > sv[i + 1]) continue;
            K = i;
        }

        System.out.println(K);
    }
}
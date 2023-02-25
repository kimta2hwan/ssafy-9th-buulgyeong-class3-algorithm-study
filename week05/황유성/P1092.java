import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1092 {
    
    static int N, M;
    static int[] limit, weight;
    
    public static void main(String[] args) throws Exception {
        readLine();
        solve();
    }
    
    static void readLine() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        limit = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        weight = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    static void solve() {
        Arrays.sort(limit);
        Arrays.sort(weight);
        
        int ans = -1;
        int left = 1;
        int right = M;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (able(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean able(int time) {
        int w = 0;
        for (int curLimit : limit) {
            for (int i = 0; i < time; i++) {
                if (curLimit >= weight[w]) {
                    w++;
                    if (w == M) return true;
                }
                else break;
            }
        }
        return false;
    }
}

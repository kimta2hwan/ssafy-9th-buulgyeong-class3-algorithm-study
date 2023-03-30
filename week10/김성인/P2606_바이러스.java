import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2606_바이러스 {
    static List<List<Integer>> list;
    static boolean[] visit;
    static int cnt = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }

        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int node) {
        visit[node] = true;
        cnt++;
        for (int i : list.get(node)) {
            if (visit[i]) continue;
            dfs(i);
        }
    }


}

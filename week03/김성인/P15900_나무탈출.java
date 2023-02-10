import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P15900_나무탈출 {
    static LinkedList<Integer>[] table;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        table = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            table[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            table[node1].add(node2);
            table[node2].add(node1);
        }

        dfs(1, 0, 0);

        System.out.println(answer % 2 == 0 ? "No" : "Yes");
    }

    static void dfs(int cur, int p, int cnt) {
        for (int num : table[cur]) {
            if (num != p) {
                dfs(num, cur, cnt + 1);
            }
        }
        if (table[cur].size() == 1) {
            answer += cnt;
        }
    }
}

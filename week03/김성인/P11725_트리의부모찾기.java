import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11725_트리의부모찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

        // tree 틀 만들기(0~6)
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            tree.add(list);
        }
        // tree에 값 넣기
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        boolean[] check = new boolean[n];
        int[] parentN = new int[n];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        check[0] = true;

        while (queue.size() != 0) {
            int node = queue.remove();
            for (int i : tree.get(node)) {
                if (!check[i]) {
                    check[i] = true;
                    queue.add(i);
                    parentN[i] = node;
                }
            }
        }
        for (int i = 1; i < parentN.length; i++) {
            sb.append(parentN[i] + 1).append("\n");
        }
        System.out.println(sb);
    }
}

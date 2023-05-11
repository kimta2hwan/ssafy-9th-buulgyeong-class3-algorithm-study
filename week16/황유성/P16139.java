import java.io.*;
import java.util.*;

public class P16139 {

    static char[] inp;
    static int q;
    static int[][] cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inp = br.readLine().toCharArray();

        cnt = new int[26][inp.length + 1];
        for (int i = 0; i < inp.length; i++) {
            cnt[inp[i] - 'a'][i + 1]++;
        }

        for (int i = 0; i < 26; i++) {
            int[] arr = cnt[i];
            for (int j = 1; j < arr.length; j++) {
                arr[j] += arr[j - 1];
            }
        }

        q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int[] arr = cnt[c - 'a'];
            sb.append(arr[r + 1] - arr[l]).append('\n');
        }
        System.out.print(sb);
    }
}

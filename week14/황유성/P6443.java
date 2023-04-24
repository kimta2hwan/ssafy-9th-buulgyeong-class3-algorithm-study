import java.io.*;
import java.util.*;

public class P6443 {

    static int N;
    static char[] inp;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            inp = br.readLine().toCharArray();

            if (set.contains(String.valueOf(inp))) continue;

            Arrays.sort(inp);

            do {
                set.add(String.valueOf(inp));
            } while (np());

            set.stream().sorted().forEach(e -> sb.append(e).append('\n'));

            set.clear();
        }

        System.out.print(sb);
    }

    static boolean np() {
        int i = inp.length - 1;
        while (i > 0 && inp[i - 1] >= inp[i]) --i;
        if (i == 0) return false;
        int j = inp.length - 1;
        while (inp[i - 1] >= inp[j]) --j;
        swap(i - 1, j);
        int k = inp.length - 1;
        while (i < k) {
            swap(i++, k--);
        }
        return true;
    }

    static void swap(int a, int b) {
        char temp = inp[a];
        inp[a] = inp[b];
        inp[b] = temp;
    }
}

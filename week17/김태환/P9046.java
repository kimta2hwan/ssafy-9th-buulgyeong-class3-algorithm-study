import java.io.BufferedReader;
import java.io.InputStreamReader;

class P9046 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String input = br.readLine();
            int[] count = new int[26];
            char maxC = 'a';
            int max = 0;

            for (char c : input.toCharArray()) {
                if (c == ' ') {
                    continue;
                }

                int i = c - 'a';
                count[i]++;

                if (count[i] > max) {
                    maxC = c;
                    max = count[i];
                } else if (count[i] == max) {
                    maxC = '?';
                }
            }

            sb.append(maxC).append('\n');
        }

        System.out.print(sb);
    }
}

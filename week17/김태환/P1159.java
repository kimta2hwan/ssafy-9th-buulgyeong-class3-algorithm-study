import java.io.BufferedReader;
import java.io.InputStreamReader;

class P1159 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[26];

        while (N-- > 0) {
            arr[br.readLine().charAt(0) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] < 5) {
                continue;
            }

            sb.append((char)('a' + i));
        }

        System.out.print(sb.length() == 0 ? "PREDAJA" : sb);
    }
}

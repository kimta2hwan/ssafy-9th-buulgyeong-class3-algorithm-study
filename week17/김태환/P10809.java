import java.io.BufferedReader;
import java.io.InputStreamReader;

class P10809 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int[] arr = new int[26];

        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }

        for (int i = 0; i < input.length; i++) {
            int n = input[i] - 'a';

            if (arr[n] == -1) {
                arr[n] = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.print(sb);
    }
}

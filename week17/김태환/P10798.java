import java.io.BufferedReader;
import java.io.InputStreamReader;

class P10798 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] input = new char[5][];
        int max = 0;

        for (int i = 0; i < 5; i++) {
            input[i] = br.readLine().toCharArray();

            if (input[i].length > max) {
                max = input[i].length;
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (max-- > 0) {
            for (int i = 0; i < 5; i++) {
                if (input[i].length <= index) {
                    continue;
                }

                sb.append(input[i][index]);
            }

            index++;
        }

        System.out.print(sb);
    }
}

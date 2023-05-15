import java.io.BufferedReader;
import java.io.InputStreamReader;

class P11365 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;

        while (!((input = br.readLine()).equals("END"))) {
            sb.append(new StringBuilder(input).reverse()).append('\n');
        }

        System.out.print(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9012_괄호 {
    public static void main(String[] args) throws IOException {
        // '('들어오면 ++ ')'들어오면 --
        // 0이면 yes 아니면 no
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받아서 버퍼에 저장
        StringBuilder sb = new StringBuilder(); // 문자열을 한 번에 출력할 수 있도록 해주는 역할
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int VPS = 0;
            char[] array = br.readLine().toCharArray();
            for (char c : array) {
                if (VPS < 0){
                    VPS = -100;
                    break;
                }

                if (c == '(') {
                    VPS++;
                } else {
                    VPS--;
                }
            }
            sb.append(VPS == 0 ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P21314_민겸수 {
    public static void main(String[] args) throws IOException {
        // 가장 큰 값은 k가 나올 때까지 먹고 출력하는 방식 마지막에 k가 없으면 남은 m만큼 1로 출력
        // 가장 작은 값은 m만 먹고 k는 안 먹고 따로 출력하는 방식

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        char[] str = br.readLine().toCharArray();
        int cnt = 0; // m의 개수

        for (char c : str) {
            if (c == 'K') {
                // 최대값
                sb1.append(5);
                for (int i = 0; i < cnt; i++) {
                    sb1.append(0);
                }

                // 최소값
                if (cnt > 0) sb2.append(1);
                for (int i = 0; i < cnt - 1; i++) {
                    sb2.append(0);
                }
                sb2.append(5);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        if (cnt != 0) {
            for (int i = 0; i < cnt; i++) {
                sb1.append(1);
            }
            sb2.append(1);
            for (int i = 0; i < cnt - 1; i++) {
                sb2.append(0);
            }
        }

        System.out.println(sb1);
        System.out.println(sb2);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1158_요세푸스문제 {
    //    int[] list = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 리스트 만들기
        ArrayList<Integer> list1 = new ArrayList<>(N);
        for (int i = 1; i < N + 1; i++) {
            list1.add(i);
        }

        int index = 0; // 제거할 인덱스
        sb.append("<");
        while (list1.size() > 0) {
            index = (index + (K - 1)) % list1.size(); // 제거할 인덱스 계산
            sb.append(list1.remove(index));
            if (list1.size() != 0) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}

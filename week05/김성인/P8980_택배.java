import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P8980_택배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 마을 수
        int c = Integer.parseInt(st.nextToken()); // 최대 용량

        int m = Integer.parseInt(br.readLine()); // 주문 개수
        int[][] order = new int[n + 1][n + 1]; // 주문 정보
        int[] stock = new int[n + 1]; // 배송지 별 배송할 택배 수
        int result = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            order[start][end] = weight;
        }
        for (int i = 1; i <= n; i++) {
            result += stock[i];
            stock[i] = 0;
            int temp = 0; // 적재된 박스들
            // 일단 다 모아
            for (int j = i + 1; j <= n; j++) {
                stock[j] += order[i][j];
            }
            // 빠르게 배송할 수 있는 거부터 적재 가용량만큼 트럭에 싣기
            for (int j = i + 1; j <= n; j++) {
                if (temp + stock[j] > c) {
                    stock[j] = c - temp;
                    for (int k = j + 1; k <= n; k++) {
                        stock[k] = 0;
                    }
                    break;
                }
                temp += stock[j];
            }
        }
        System.out.println(result);
    }
}

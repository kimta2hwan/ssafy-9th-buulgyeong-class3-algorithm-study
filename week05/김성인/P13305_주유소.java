import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] distance = new int[n - 1];
        int[] station = new int[n];
        long cost = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            station[i] = Integer.parseInt(st.nextToken());
        }

        int minIdx = 0; // 현 시점 가장 기름값이 싼 곳 인덱스
        for (int i = 1; i < n; i++) {
            if (station[i] <= station[minIdx]) {
                for (int j = minIdx; j < i; j++) {
                    cost += (long) distance[j] * station[minIdx];
                }
                minIdx = i;
            }
        }
        if (minIdx != n - 1) {
            for (int i = minIdx; i < n - 1; i++) {
                cost += (long) distance[i] * station[minIdx];
            }
        }
        System.out.println(cost);
    }
}

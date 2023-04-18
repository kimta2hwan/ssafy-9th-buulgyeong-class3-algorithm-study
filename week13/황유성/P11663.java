import java.io.*;
import java.util.*;

public class P11663 {

    static int N, M;
    static int[] points;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        points = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(lowerBound(end) - upperBound(start) + 1).append('\n');
        }
        System.out.print(sb);
    }

    static int lowerBound(int target) {
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (points[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    static int upperBound(int target) {
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (points[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

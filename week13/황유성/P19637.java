import java.io.*;
import java.util.*;

public class P19637 {

    static int N, M;
    static String[] title;
    static int[] upperbound;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        title = new String[N];
        upperbound = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            title[i] = st.nextToken();
            upperbound[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int stat = Integer.parseInt(br.readLine());

            int pos = binarySearch(stat);

            sb.append(title[pos]).append('\n');
        }
        System.out.print(sb);
    }

    static int binarySearch(int target) {
        int left = 0;
        int right = upperbound.length - 1;
        int ret = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (upperbound[mid] > target) {
                right = mid - 1;
            } else if (upperbound[mid] < target) {
                left = mid + 1;
            } else {
                ret = mid;
                right = mid - 1;
            }
        }
        if (ret == -1) ret = left;
        return ret;
    }
}

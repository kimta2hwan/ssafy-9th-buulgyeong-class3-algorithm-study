import java.io.*;
import java.util.*;

public class P20444 {

    static int n;
    static long k;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
    }

    static void solve() {
        long left = 0;
        long right = n / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            long numPiece = (mid + 1) * (n - mid + 1);
            if (numPiece < k) {
                left = mid + 1;
            } else if (numPiece == k) {
                System.out.println("YES");
                return;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("NO");
    }
}

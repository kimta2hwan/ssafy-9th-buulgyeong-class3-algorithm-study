import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class P3151 {

    static final int X = 10000;
    static int N;
    static int[] counts = new int[20001];

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            counts[Integer.parseInt(st.nextToken()) + X]++;
        }
    }

    static void solve() {
        int[] A = IntStream.range(-10000, 10001).filter(e -> counts[e + X] > 0).toArray();

        long answer = 0;

        if (counts[X] >= 3) {
            answer += (long) counts[X] * (counts[X] - 1) * (counts[X] - 2) / 6;
        }

        for (int i = 0; i < A.length - 1; i++) {
            int left = A[i];
            for (int j = i + 1; j < A.length; j++) {
                int right = A[j];
                if (2 * left + right == 0) {
                    answer += (long) counts[left + X] * (counts[left + X] - 1) / 2 * counts[right + X];
                }
                if (left + 2 * right == 0) {
                    answer += (long) counts[left + X] * counts[right + X] * (counts[right + X] - 1) / 2;
                }
            }
        }

        for (int l = 0; l < A.length - 1; l++) {
            int left = A[l];
            int m = l + 1;
            int r = A.length - 1;
            int mid = A[m], right = A[r];
            while (m < r) {
                int sum = left + mid + right;
                if (sum > 0) {
                    right = A[--r];
                } else {
                    if (sum == 0) {
                        answer += (long) counts[left + X] * counts[mid + X] * counts[right + X];
                    }
                    mid = A[++m];
                }
            }
        }

        System.out.println(answer);
    }
}

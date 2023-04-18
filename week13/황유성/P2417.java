import java.io.*;


public class P2417 {

    static long n;
    static double target;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
    }

    static void solve() {
        target = (double) n;

        long start = 0;
        long end = n;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (Math.pow(mid, 2) >= target) end = mid - 1;
            else start = mid + 1;
        }
        System.out.println(start);
    }
}

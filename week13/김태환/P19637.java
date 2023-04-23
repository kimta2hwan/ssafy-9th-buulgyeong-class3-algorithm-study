import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class P19637 {

    private static String[] styles;
    private static int[] scores;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        styles = new String[N + 1];
        scores = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            styles[i] = st.nextToken();
            scores[i] = Integer.parseInt(st.nextToken());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (M-- > 0) {
            bw.write(styles[binarySearch(Integer.parseInt(br.readLine()))]);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static int binarySearch(int score) {
        int start = 1;
        int end = N;

        while (start < end) {
            int mid = (start + end) >> 1;

            if (scores[mid] >= score) {
                end = mid;

            } else {
                start = mid + 1;
            }
        }
        
        return end;
    }
}

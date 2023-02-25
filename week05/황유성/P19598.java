import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P19598 {

    static int N;
    static Meeting[] arr;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    static void solve() {
        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int roomCnt = 0;
        int readyCnt = 0;
        for (int i = 0; i < N; i++) {
            int startTime = arr[i].start;
            int endTime = arr[i].end;
            while (!pq.isEmpty() && startTime >= pq.peek()) {
                pq.poll();
                readyCnt++;
            }
            if (readyCnt == 0) roomCnt++;
            else readyCnt--;

            pq.offer(endTime);
        }

        System.out.println(roomCnt);
    }

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            return this.start - o.start;
        }
    }
}

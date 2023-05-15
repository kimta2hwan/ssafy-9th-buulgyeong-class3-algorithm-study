import java.io.*;
import java.util.*;

public class P3029 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int curTime = timeToInt(br.readLine());
        int tgtTime = timeToInt(br.readLine());
        if (curTime >= tgtTime) {
            tgtTime += 3600 * 24;
        }
        String answer = timeToStr(tgtTime - curTime);
        System.out.println(answer);
    }

    static int timeToInt(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        return 3600 * h + 60 * m + s;
    }

    static String timeToStr(int time) {
        int h = time / 3600;
        time %= 3600;
        int m = time / 60;
        int s = time % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}

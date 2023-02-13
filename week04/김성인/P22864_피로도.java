import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P22864_피로도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); // 일 피로도
        int b = Integer.parseInt(st.nextToken()); // 일 양
        int c = Integer.parseInt(st.nextToken()); // 휴식 피로도
        int m = Integer.parseInt(st.nextToken()); // 번아웃 피로도

        int hour = 0;
        int work = 0;
        int tired = 0;

        while (hour++ < 24) {
            if (tired + a > m) { // 일 할 수 없는 피로도라면 휴식
                tired = Math.max(tired - c, 0); // 휴식 후 피로도
            } else { // 일해도 되는 피로도
                tired += a;
                work += b;
            }
        }
        System.out.println(work);
    }
}

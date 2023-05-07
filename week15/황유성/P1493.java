import java.util.*;
import java.io.*;


public class P1493 {
    static int length, width, height, n;
    static boolean flag;
    static int[] numCube;

    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        numCube = new int[20];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            numCube[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }


        int ans = divide(length, width, height);
        System.out.println(flag ? -1 : ans);
    }

    static int divide(int l, int w, int h) {
        if (flag || l == 0 || w == 0 || h == 0) return 0;

        int min = Math.min(Math.min(l, w), h);
        int exp = (int) (Math.log(min) / Math.log(2));
        for (int i = exp; i >= 0; i--) {
            if (numCube[i] == 0) continue;
            numCube[i]--;
            int pow = 1 << i;
            return 1 + divide(l - pow, w, h) + divide(pow, w - pow, h) + divide(pow, pow, h - pow);
        }
        flag = true;
        return 0;
    }
}
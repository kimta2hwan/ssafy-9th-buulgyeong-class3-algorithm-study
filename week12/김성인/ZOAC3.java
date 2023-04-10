import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZOAC3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[][] keyboard = new char[3][10];
        char[] checker = {'q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v'};
        int[] left = new int[2];
        int[] right = new int[2];
        int result = 0;

        keyboard[0] = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        keyboard[1] = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';'};
        keyboard[2] = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/'};

        char c1 = st.nextToken().charAt(0);
        char c2 = st.nextToken().charAt(0);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if (keyboard[i][j] == c1) {
                    left[0] = i;
                    left[1] = j;
                } else if (keyboard[i][j] == c2) {
                    right[0] = i;
                    right[1] = j;
                }
            }
        }

        char[] list = br.readLine().toCharArray();
        for (char target : list) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 10; j++) {
                    if (keyboard[i][j] == target) {
                        boolean isLeft = false;
                        for (char c : checker) {
                            if (c == target) {
                                isLeft = true;
                                break;
                            }
                        }
                        if (isLeft) {
                            result += Math.abs(left[0] - i) + Math.abs(left[1] - j) + 1;
                            left[0] = i;
                            left[1] = j;
                        } else {
                            result += Math.abs(right[0] - i) + Math.abs(right[1] - j) + 1;
                            right[0] = i;
                            right[1] = j;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10845_큐 {
    static int size = 0;
    static int head = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(getSize()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);

    }

    public static void push(int i) {
        arr[head + size++] = i;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        }
        int tmp = arr[head++];
        size--;
        return tmp;
    }

    public static int getSize() {
        return size;
    }

    public static int empty() {
        return size == 0 ? 1 : 0;
    }

    public static int front() {
        if (size == 0) {
            return -1;
        }
        return arr[head];
    }

    public static int back() {
        if (size == 0) {
            return -1;
        }
        return arr[head + size - 1];
    }
}

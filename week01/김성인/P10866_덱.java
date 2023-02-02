import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P10866_덱 {
    public static LinkedList<Integer> deck = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(pop_back()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
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

    public static void push_front(int i) {
        deck.addFirst(i);
    }

    public static void push_back(int i) {
        deck.addLast(i);
    }

    public static int pop_front() {
        if (deck.size() == 0) return -1;
        return deck.removeFirst();
    }

    public static int pop_back() {
        if (deck.size() == 0) return -1;
        return deck.removeLast();
    }

    public static int size() {
        return deck.size();
    }

    public static int empty() {
        return deck.size() == 0 ? 1 : 0;
    }

    public static int front() {
        if (deck.size() == 0) return -1;
        return deck.getFirst();
    }

    public static int back() {
        if (deck.size() == 0) return -1;
        return deck.getLast();
    }
}

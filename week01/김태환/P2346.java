import java.util.ArrayList;

class Balloon {
    int point;
    int value;

    public Balloon(int point, int value) {
        this.point = point;
        this.value = value;
    }
}

class P2346 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        ArrayList<Balloon> deque = new ArrayList<>();
        int N = read(), index = 0;

        for (int i = 1; i <= N; i++) {
            deque.add(new Balloon(i, read()));
        }

        while (true) {
            Balloon move = deque.remove(index);
            sb.append(move.point).append(' ');

            if (deque.size() == 0) {
                break;
            }

            if (move.value > 0) {
                index += move.value - 1;
                index %= deque.size();

            } else {
                index += move.value;

                while (index < 0) {
                    index += deque.size();
                }
            }
        }

        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;

        if (isNegative) {
            n = System.in.read() & 15;
        }

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return isNegative ? ~n + 1 : n;
    }
}
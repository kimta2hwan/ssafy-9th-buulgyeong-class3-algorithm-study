import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16508 {

    static class Book {
        int price;
        char[] title;

        Book(int price, char[] title) {
            this.price = price;
            this.title = title;
        }
    }

    static char[] T;
    static int N, answer;
    static Book[] books;

    public static void main(String[] args) throws Exception {
        readInput();
        solve();
    }

    static void readInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine().toCharArray();
        N = Integer.parseInt(br.readLine());
        books = new Book[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            books[i] = new Book(
                    Integer.parseInt(st.nextToken()),
                    st.nextToken().toCharArray()
            );
        }
    }

    static void solve() {
        answer = Integer.MAX_VALUE;
        subset(0, 0, 0);
        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

    static void subset(int depth, int totalPrice, int mask) {
        if (totalPrice >= answer) return;
        if (depth == books.length) {
            int[] cnt = new int[26];
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) == 0) continue;
                for (char c : books[i].title) {
                    cnt[c - 'A']++;
                }
            }

            for (char c : T) {
                if (cnt[c - 'A']-- == 0) return;
            }

            answer = totalPrice;
            return;
        }

        subset(depth + 1, totalPrice, mask);
        subset(depth + 1, totalPrice + books[depth].price, mask | 1 << depth);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            list1.add(i);
        }

        while (list1.size() > 1) {
            list1.removeFirst(); // 카드 버리기
            list1.addLast(list1.removeFirst()); // 카드 밑으로 넣기
        }
        System.out.println(list1.getFirst());
    }
}

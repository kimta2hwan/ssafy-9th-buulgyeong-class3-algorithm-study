import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P20364_부동산다툼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 땅 개수
        int q = Integer.parseInt(st.nextToken()); // 오리 수

        boolean[] visit = new boolean[n + 1]; // 소유된 땅 기록
        // 가지고 싶은 땅 번호 / 2 가 1이 될때까지 반복해주고
        // 그 동안 visit배열에 해당 땅 번호가 있으면 해당 땅 번호 출력
        // 1까지 오면 0을 출력
        for (int i = 0; i < q; i++) {
            int ground = Integer.parseInt(br.readLine());
            int buying = ground;
            ArrayList<Integer> groundList = new ArrayList<>();
            int cnt = 0;
            while (ground != 1) {
                if (visit[ground]) {
                    groundList.add(ground);
                    cnt++;
                }
                ground /= 2;
            }
            if (groundList.size() == 0) {
                visit[buying] = true;
                sb.append(0);
            } else {
                sb.append(groundList.get(cnt - 1));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

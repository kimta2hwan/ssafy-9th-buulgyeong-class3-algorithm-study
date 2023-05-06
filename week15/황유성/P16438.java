import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class P16438 {

    static int N;
    static char[][] answer;

    public static void main(String[] args) throws Exception {
        N = (new Scanner(System.in)).nextInt();
        answer = new char[7][N];
        for (int i = 0; i < 7; i++) {
            answer[i][0] = 'A';
            Arrays.fill(answer[i], 1, N, 'B');
        }

        int num = (int) Math.pow(2, Math.ceil(Math.log10(N) / Math.log10(2)));
        makeTeam(0, 0, num);

        StringBuilder sb = new StringBuilder();
        Stream.of(answer).forEach(line -> sb.append(line).append('\n'));
        System.out.print(sb);
    }

    static void makeTeam(int day, int start, int num) {
        if (start >= N || num == 1) return;
        int half = num >> 1;
        int mid = Math.min(start + half, N);
        for (int i = start; i < mid; i++) {
            answer[day][i] = 'A';
        }
        int end = Math.min(start + num, N);
        for (int i = mid; i < end; i++) {
            answer[day][i] = 'B';
        }
        makeTeam(day + 1, start, half);
        makeTeam(day + 1, start + half, half);
    }
}

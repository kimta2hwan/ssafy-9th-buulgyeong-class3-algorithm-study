import java.util.Arrays;

class P15654 {

    private static StringBuilder sb;
    private static int[] numbers, sequence;
    private static int N, M;

    public static void main(String[] args) throws Exception {
        sb = new StringBuilder();
        N = read();
        M = read();
        numbers = new int[N + 1];
        sequence = new int[M];

        for (int i = 1; i <= N; i++) {
            numbers[i] = read();
        }

        Arrays.sort(numbers);
        perm(0, 0);

        System.out.print(sb);
    }
    
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }

    private static void perm(int depth, int mask) {
        if (depth == M) {
            for (int number : sequence) {
                sb.append(number).append(' ');
            }

            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if ((mask & (1 << i)) != 0) {
                continue;
            }
            
            sequence[depth] = numbers[i];
            perm(depth + 1, mask | (1 << i));
        }
    }
}

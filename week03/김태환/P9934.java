class P9934 {
    
    public static void main(String[] args) throws Exception {
        int[] pow = {2 ,4, 8, 16, 32, 64, 128, 256, 512, 1024};

        int K = read();
        int N = pow[K - 1] - 1;

        int[] tree = new int[N];

        for (int i = 0; i < N; i++) {
            tree[i] = read();
        }

        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[N];
        int point;

        for (int i = 0; i < K; i++) {
            point = N / pow[i];
            
            for (int j = point; j < N; j += point + 1) {
                if (visited[j]) {
                    continue;
                }

                sb.append(tree[j]).append(" ");
                visited[j] = true;
            }

            sb.append('\n');
        }
        
        System.out.println(sb);
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
}

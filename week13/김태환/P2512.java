class P2512 {

    private static int[] arr;
    private static int N, M, max = -1;

    public static void main(String[] args) throws Exception {
        N = read();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = read();

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        M = read();
        System.out.print(binarySearch());
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
    
    private static int binarySearch() {
        int start = 0;
        int end = max;

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                sum += mid > arr[i] ? arr[i] : mid;
            }

            if (sum > M) {
                end = mid - 1;

            } else if (sum < M) {
                start = mid + 1;

            } else {
                return mid;
            }
        }

        return end;
    }
}

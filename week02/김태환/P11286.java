class P11286 {
    public static void main(String[] args) throws Exception {
        int N = read();

        StringBuilder sb = new StringBuilder();
        Heap heap = new Heap(N);

        while (N-- > 0) {
            int x = read();

            if (x == 0) {
                sb.append(heap.poll()).append('\n');
                continue;
            }

            heap.offer(x);
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

    private static class Heap {
        int[] heap;
        int size;

        Heap(int size) {
            this.heap = new int[size + 1];
        }

        void offer(int x) {
            heap[++size] = x;
            int i = size << 1;

            while ((i >>= 1) > 1) {
                if (!swap(i)) {
                    break;
                }
            }
        }

        int poll() {
            if (size == 0) {
                return 0;
            }

            int x = heap[1];
            heap[1] = heap[size--];
            int i = 1;

            while ((i <<= 1) <= size) {
                if (i < size && compare(i + 1, i)) {
                    i++;
                }

                if (!swap(i)) {
                    break;
                }
            }

            return x;
        }

        boolean swap(int i) {
            int j = i >> 1;

            if (compare(j, i)) {
                return false;
            }

            int parent = heap[j];
            int child = heap[i];
            
            heap[j] = child;
            heap[i] = parent;

            return true;
        }

        boolean compare(int i, int j) {
            int a = heap[i];
            int b = heap[j];

            if (a < 0) {
                a = ~a + 1;
            }

            if (b < 0) {
                b = ~b + 1;
            }

            if (a == b) {
                return heap[i] < heap[j];
            }
            
            return a < b;
        }
    }
}

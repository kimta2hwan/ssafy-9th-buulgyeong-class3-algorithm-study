import java.util.Arrays;

class P2776 {
	
	static int[] num;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int T = read();
		
		while (T-- > 0) {
			int N = read();
			num = new int[N];
			
			for (int i = 0; i < N; i++) {
				num[i] = read();
			}
			
			Arrays.sort(num);
			
			int M = read();
			
			for (int i = 0; i < M; i++) {
				sb.append(binarySearch(read())).append('\n');
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
	
	private static int binarySearch(int key) {
		int low = 0, high = num.length - 1, mid;
        
        if (key > num[high] || key < num[low]) {
        	return 0;
        }
        
        while (high >= low) {
            mid = (low + high) / 2;

            if (num[mid] > key) {
            	high = mid - 1;
            	
            } else if (num[mid] < key) {
            	low = mid + 1;
            	
            } else {
            	return 1;
            }
        }

        return 0;
	}
}

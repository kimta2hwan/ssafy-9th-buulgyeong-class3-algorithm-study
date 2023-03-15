import java.util.Arrays;

class P2470 {
	public static void main(String[] args) throws Exception {
		int N = read();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = read();
		}
		
		Arrays.sort(arr);
		
		int leftPointer = 0;
		int rightPointer = N - 1;
		
		int min = Integer.MAX_VALUE;
		int answer1 = 0;
		int answer2 = 0;
		
		while (leftPointer < rightPointer) {
			int sum = arr[rightPointer] + arr[leftPointer];
			int abs = Math.abs(sum);
			
			if (abs < min) {
				min = abs;
				answer1 = leftPointer;
				answer2 = rightPointer;
			}
			
			if (sum > 0) {
				rightPointer--;
				
			} else {
				leftPointer++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[answer1]).append(' ').append(arr[answer2]);
		
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class P14400 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] pointX = new int[n];
		int[] pointY = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			pointX[i] = Integer.parseInt(st.nextToken());
			pointY[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(pointX);
		Arrays.sort(pointY);
		
		int x = pointX[n / 2];
		int y = pointY[n / 2];
		long sum = 0;
		
		for (int i = 0; i < n; i++) {
			sum += Math.abs(x - pointX[i]) + Math.abs(y - pointY[i]);
		}
		
		System.out.println(sum);
	}
}

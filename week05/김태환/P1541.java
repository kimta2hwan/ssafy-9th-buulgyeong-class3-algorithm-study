import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P1541 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer subtract = new StringTokenizer(br.readLine(), "-");
		int sum = Integer.MAX_VALUE;
		
		while (subtract.hasMoreTokens()) {
			StringTokenizer addition = new StringTokenizer(subtract.nextToken(), "+");
			int temp = 0;
			
			while (addition.hasMoreTokens()) {
				temp += Integer.parseInt(addition.nextToken());
			}
			
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
				
			} else {
				sum -= temp;
			}
		}
		
		System.out.println(sum);
	}
}

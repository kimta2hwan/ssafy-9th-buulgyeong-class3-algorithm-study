import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2164 {
	static int N;
	static Queue<Integer> Q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			Q.add(i);
		}
	}
	
	public static void solve() {
		while( Q.size() != 1) {
			//버리고
			Q.remove();
			//뒤로 옮기고
			int num = Q.poll();
			Q.offer(num);
		}
		System.out.println(Q.peek());
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

}
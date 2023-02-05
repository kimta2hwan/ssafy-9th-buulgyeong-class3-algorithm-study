import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2075 {
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
	
	
	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pQueue.offer( Integer.parseInt( st.nextToken() ) );
			}
		}
	}
	
	static void solve() throws IOException {
		for (int i = 0; i < N-1; i++) {
			pQueue.poll();
		}
		System.out.println( pQueue.poll() );
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}
}

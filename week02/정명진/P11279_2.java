import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class P11279_2 {
	static int N, num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static PriorityQueue<Integer> qQueue = new PriorityQueue<>(Collections.reverseOrder());
	
	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
	}
	
	static void solve() throws IOException {
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			if( num > 0 ) {
				qQueue.add(num);
			}else if( num == 0 ) {
				if( !qQueue.isEmpty() ) bw.write(qQueue.poll() + "\n");
				else  bw.write("0" + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
		
	}
}

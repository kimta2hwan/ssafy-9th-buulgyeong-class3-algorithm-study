import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1158 {
	static int N, K;
	static Queue<Integer> Q = new LinkedList<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}

	static void solve() {
		//큐 채우기
		for (int i = 1; i <= N; i++) {
			Q.offer(i);
		}
		
		//출력
		System.out.print("<");
		
		while( Q.size() > 1) {
			for (int i = 0; i < K; i++) {
				if( i == K-1 ) {
					System.out.print( Q.poll() + ", " );
				}else {
					int num = Q.poll();
					Q.offer(num);
				}
			}
		}
		
		System.out.print(Q.poll() +">");
	}
	public static void main(String[] args) throws IOException {
		input();
		solve();		
	}
}
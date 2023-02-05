import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P1269 {
	static int N, M, tmp;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static Set<Integer> A = new HashSet<Integer> ();
	static Set<Integer> B = new HashSet<Integer> ();
	

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A.add( Integer.parseInt(st.nextToken()) );
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B.add( Integer.parseInt(st.nextToken()) );
		}
	}

	public static void solve() {
		Set<Integer> tmp_A = new HashSet<Integer> (A);
		A.removeAll(B);
		B.removeAll(tmp_A);
		System.out.println( A.size() + B.size() );
	}
	public static void main(String[] args) throws IOException {
		input();
		solve();		
	}
}

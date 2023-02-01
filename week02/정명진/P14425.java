package algoLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P14425 {
	static int N, M, CNT;
	static Set<String> set = new HashSet<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
	}

	public static void solve() throws IOException {
		for (int i = 0; i < M; i++) {
			if( set.contains( br.readLine() ) ) {
				CNT++;
			}
		}
		System.out.println(CNT);
	}
	public static void main(String[] args) throws IOException {
		input();
		solve();		
	}
}

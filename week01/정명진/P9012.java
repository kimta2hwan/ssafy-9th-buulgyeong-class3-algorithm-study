import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9012 {
	static int T;
	static String STR;
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static Stack<Character> S = new Stack<>();
	
	public static void input() throws IOException{
		STR = BR.readLine();
	}
	
	public static void solve() {
		int i;
		for (i = 0; i < STR.length(); i++) {
			if( STR.charAt(i) == ')' && ! S.empty()) {
				S.pop();
			}else if(STR.charAt(i) == ')' && S.empty() ){
				break;
			}else {
				S.push( STR.charAt(i) );
			}
		}
		
		if( S.empty() && i == STR.length() ) System.out.println("YES");
		else System.out.println("NO");
		S.clear();
		
	}
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(BR.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			input();
			solve();
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11279 {
	static int N, idx, tmp, max;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr ;

	public static void inputNsolve() throws  IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(br.readLine());
			solve();
		}
		idx = 0;
	}

	public static void solve() {
		if( tmp == 0 ) {
			printMax();
			removeMax();
		}else if ( tmp > 0 ){
			arr[idx++] = tmp;
		}
	}
	
	public static void printMax() {
		max = 0;
		for (int i = 0; i < idx; i++) {
			if( arr[i] > max) {
				max = arr[i];
			}
		}
		
		System.out.println(max);
	}
	
	public static void removeMax() {
		for (int i = 0; i < idx; i++) {
			if( arr[i] == max) {
				arr[i] = 0;
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		inputNsolve();	
	}
}

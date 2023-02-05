
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P11286 {
    static int N, X;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>() {
    	@Override
    	public int compare(Integer i1, Integer i2) {
    		if( Math.abs(i1) == Math.abs(i2) ) 
    			return  i1 > i2 ? 1 : -1;
			else
				return Math.abs(i1) > Math.abs(i2) ? 1 : -1; 
    	}
    });
    
    
    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
    
    static void solve() throws IOException {
        for (int i = 0; i < N; i++) {
            X = Integer.parseInt(br.readLine());
            if( X == 0 ) {
            	if(  pQueue.peek() != null ) System.out.println( pQueue.poll() );            		
            	else System.out.println( "0");
            }else {
                pQueue.offer(X);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
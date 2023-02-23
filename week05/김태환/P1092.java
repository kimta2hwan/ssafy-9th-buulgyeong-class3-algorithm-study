import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class P1092 {
	public static void main(String[] args) throws Exception {
		int N = read();
		Integer[] crane = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			crane[i] = read();
		}
		
		List<Integer> box = new ArrayList<>();
		int M = read();
		
		for (int i = 0; i < M; i++) {
			box.add(read());
		}
		
		Arrays.sort(crane, (c1, c2) -> c2 - c1);
		Collections.sort(box, (b1, b2) -> b2 - b1);
		
		if (box.get(0) > crane[0]) {
			System.out.println(-1);
			return;
		}
		
		int time = 0;
		
		while (!box.isEmpty()) {
			int b = 0;
			
			for (int c = 0; c < N;) {
				if (b == box.size()) {
					break;
				}
				
				if (crane[c] >= box.get(b)) {
					box.remove(b);
					c++;
					
				} else {
					b++;
				}
			}
			
			time++;
		}
		
		System.out.println(time);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}

        if (c == 13) {
            System.in.read();
        }
		
		return n;
	}
}

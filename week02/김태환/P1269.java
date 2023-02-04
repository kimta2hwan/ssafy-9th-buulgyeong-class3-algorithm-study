import java.util.HashSet;
import java.util.Set;

class P1269 {
	public static void main(String[] args) throws Exception {
		int A = read();
		int B = read();
		
		Set<Integer> set = new HashSet<>();
		
		while (A-- > 0) {
			set.add(read());
		}
		
		while (B-- > 0) {
			int n = read();
			
			if (set.contains(n)) {
				set.remove(n);
				continue;
			}
			
			set.add(n);
		}
		
		System.out.println(set.size());
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

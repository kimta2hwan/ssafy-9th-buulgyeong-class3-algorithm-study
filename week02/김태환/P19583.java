import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class P19583 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String S = st.nextToken();
		String E = st.nextToken();
		String Q = st.nextToken();
		
		Set<String> enter = new HashSet<>();
		Set<String> out = new HashSet<>();
		
		String log;
		
		while ((log = br.readLine()) != null && !log.isEmpty()) {
			st = new StringTokenizer(log);
			
			String time = st.nextToken();
			String name = st.nextToken();
			
			if (time.compareTo(S) <= 0) enter.add(name);
			else if (time.compareTo(E) >= 0 && time.compareTo(Q) <= 0 && enter.contains(name)) {
				out.add(name);
			}
		}
		
		System.out.println(out.size());
	}
}

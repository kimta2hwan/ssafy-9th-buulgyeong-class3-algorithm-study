
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class P6416 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		HashSet<Integer> setU = new HashSet<>();
		HashSet<Integer> setV = new HashSet<>();
		boolean isTree = false;
		int t = 1;
		loop: while (true) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				if (u == 0 || v == 0) {
					if (setV.size() != 0) {
						int root = 0;
						Iterator<Integer> iter = setU.iterator();
						while (iter.hasNext()) {
							if (!setV.contains(iter.next()))
								++root;
						}
						if (root != 1)
							isTree = true;
					}

					if (isTree)
						sb.append("Case " + t + " is not a tree.\n");
					else
						sb.append("Case " + t + " is a tree.\n");

					t++;

					setU = new HashSet<>();
					setV = new HashSet<>();
					isTree = false;
					continue;

				}

				if (u == -1 || v == -1)
					break loop;
				if (!setV.add(v))
					isTree = true;

				setU.add(u);

			}
		}

		System.out.println(sb);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1620 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, String> pokedex1 = new HashMap<>();
		Map<String, String> pokedex2 = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String pokeNm = br.readLine();
			pokedex1.put(Integer.toString(i), pokeNm);
			pokedex2.put(pokeNm, Integer.toString(i));
		}
		
		for(int i=0; i<M; i++) {
			String quiz = br.readLine();
			if(pokedex1.containsKey(quiz)) {
				System.out.println(pokedex1.get(quiz));
			}
			if(pokedex2.containsKey(quiz)) {
				System.out.println(pokedex2.get(quiz));
			}
		}

	}

}
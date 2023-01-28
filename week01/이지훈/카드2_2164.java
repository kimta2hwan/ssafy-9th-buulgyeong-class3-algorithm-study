import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class 카드2_2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("파일이름")));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		int cardNum = Integer.parseInt(input);
		
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		for(int i= 1; i <= cardNum; i++) {
			queue.add(i);
		}
		
		boolean remove = true;
		while(queue.size() != 1) {
			if(remove)queue.pollFirst();
			else queue.add(queue.pollFirst());
			
			remove = !remove;
		}
		
		bw.write(String.valueOf(queue.poll()));
		
		br.close();
		bw.close();
		
	}

}

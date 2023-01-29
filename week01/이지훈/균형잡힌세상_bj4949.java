import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class 균형잡힌세상_bj4949 {
	public static void main(String[] args) throws IOException {
		// 제출용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 파일로 받을때
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("4949.txt")));
		
		while(true) {
			String s = br.readLine();
			// 이상하게 테스트케이스 숫자를 안주고 .으로 끝낸다.
			if(s.equals("."))break;
			
			boolean isRight = true;
			
			ArrayDeque<Character> stack = new ArrayDeque<>();
			
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				
				if(c == '(' || c == '[')stack.add(c);

				if(c == ')') {
					if(!stack.isEmpty() && stack.peekLast() == '(')stack.pollLast();
					else isRight = false;
				}else if(c == ']') {
					if(!stack.isEmpty() && stack.peekLast() == '[')stack.pollLast();
					else isRight = false;
				}
			}
			if(stack.size() > 0)isRight = false;
			
			System.out.println(isRight?"yes":"no");
			
		}
		
		
		
	}
}

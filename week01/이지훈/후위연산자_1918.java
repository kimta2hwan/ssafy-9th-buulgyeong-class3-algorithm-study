import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class 후위연산자_1918 {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("1918.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		String operators = "+-*/()";
		
		String result = "";
		ArrayDeque<Character> stack = new ArrayDeque<>();
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
//			연산자가 아니면 그냥 담기
			if(!operators.contains(String.valueOf(c)))result+=c;
			else {
				int priority = getPriority(c);
				if(c == ')') {
					while(!stack.isEmpty()) {
						char popped = stack.pollLast();
						if(popped == '(')break;
						result += popped;
					}
				}else if(c == '(') {
					stack.add(c);
				}else {
					while(!stack.isEmpty()){
						char popped = stack.peekLast();
						// 여는괄호 또는 바닥을 만날때까지 자신보다 크거나 같은 우선순위를 다 빼기
						if(popped != '(' && getPriority(popped) >= priority) {
							result += popped;
							stack.pollLast();
						}else {
							break;
						}
					}
					stack.add(c);
				}
			}
		}
		
		while( !stack.isEmpty()){
			result += stack.pollLast();
		}
		
		bw.write(result);
		
		br.close();
		bw.close();
	}

	static int getPriority(char c) {
		if(c == '+' || c == '-')return 1;
		else if(c =='*' || c =='/')return 2;
		return 0;
	}
}

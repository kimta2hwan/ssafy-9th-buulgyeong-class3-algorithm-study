import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1541 {

	static String input;
	static List<Integer> num;
	static List<Character> oper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();

		num = new ArrayList<>();
		oper = new ArrayList<>();

		// 숫자와 연산자 분리
		int cnt = 0;
		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i))) {
				cnt++;
			} else {
				oper.add(input.charAt(i));
				int n = 0;
				for (int j = i - cnt; j < i; j++) {
					n *= 10;
					n += input.charAt(j) - '0';
				}
				num.add(n);
				cnt = 0;
			}
		}
		int n = 0;
		for (int i = input.length() - cnt; i < input.length(); i++) {
			n *= 10;
			n += input.charAt(i) - '0';
		}
		num.add(n);

		// oper에 -가 나오면 그 뒤는 전부 -로 변경
		int i = 0;
		for (i = 0; i < oper.size(); i++) {
			if (oper.get(i) == '-') {
				i++;
				break;
			}
		}
		while (i < oper.size()) {
			oper.set(i, '-');
			i++;
		}

		// 계산
		int result = num.get(0);
		for (i = 0; i < oper.size(); i++) {
			if (oper.get(i) == '+') {
				result += num.get(i + 1);
			} else {
				result -= num.get(i + 1);
			}
		}

		System.out.println(result);

	}

}

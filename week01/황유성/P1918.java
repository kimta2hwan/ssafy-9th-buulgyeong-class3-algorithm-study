import java.util.*;

/*
1. 피연산자의 순서에는 변함이 없다
2. 스택에 연산자를 순서대로 담는다
3. 이때 연산자 우선순위도 같이 담는다
    1) 괄호: 괄호 하나당 연산자 우선순위 2 증가
    2) 곱셈, 나눗셈: 연산자 우선순위 1 증가
    3) 더 왼쪽에 있는 연산자: 연산자 우선순위 수치가 동등할 경우, 기존 스택에 있는 것을 더 먼저 표시한다
4. 스택에는 연산자 우선순위가 높을수록 위에 저장되는 구조가 유지된다
5. 스택에서 반환되는 순서가 곧 후위 표기식에 자리잡는 순서가 된다
*/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        ArrayList<Character> answer = new ArrayList<>(s.length());
        int bracketCnt = 0;
        Stack<Pair> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                answer.add(c);
            } else if (c == '(') {
                bracketCnt++;
            } else if (c == ')') {
                bracketCnt--;
            } else {
                int curPriority = 2 * bracketCnt + (c == '*' || c == '/' ? 1 : 0);
                while (!st.empty() && st.peek().priority >= curPriority) {
                    answer.add(st.pop().operator);
                }
                st.push(new Pair(c, curPriority));
            }
        }
        while (!st.empty()) {
            answer.add(st.pop().operator);
        }
        answer.forEach(System.out::print);
    }
}

class Pair {
    char operator;
    int priority;

    Pair() {}
    Pair(char operator, int priority) {
        this.operator = operator;
        this.priority = priority;
    }
}
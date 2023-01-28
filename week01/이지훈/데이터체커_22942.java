import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
 
// 도움
// https://imzzan.tistory.com/17
public class 데이터체커_22942 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("파일이름")));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		int circleNum = Integer.parseInt(input);
		ArrayList<int[]> list = new ArrayList<>();
		ArrayDeque<int[]> stack = new ArrayDeque<int[]>();
		boolean result = true;
		
		for (int i = 0; i < circleNum; i++) {
			String[] line = br.readLine().split(" ");
			int xPosition = Integer.parseInt(line[0]);
			int radius = Integer.parseInt(line[1]);
			
			int leftEnd = xPosition - radius;
			int rightEnd = xPosition + radius;
			
//			1 : 왼쪽끝, 여는괄호 역할, 0: 오른쪽 끝, 닫는괄호 역할
			list.add(new int[]{leftEnd,i,1});
			list.add(new int[]{rightEnd,i,0});
		}
		
//		원의 왼쪽, 오른쪽 끝 선들을 오름차순 정렬 
		list.sort((a,b)-> a[0] - b[0]);
		
		for(int[] circle : list) {
			int xPosition = circle[0];
			int circleId = circle[1];
			int open = circle[2];
			
			if(!stack.isEmpty() && stack.peekLast()[0] == xPosition) {
				result = false;
				break;
			}
			if(open == 1) {
				stack.add(circle);
			}else {
				if(stack.peekLast()[1] != circleId) {
					result = false;
					break;
				}else {
					stack.pollLast();
				}
			}
		}
		
		bw.write(result?"YES":"NO");
		
		br.close();
		bw.close();
	}

}
/***
 * 
2
4 2
3 1
YES
이경우를 위해서는 중복체크같은게 필요할듯
*/

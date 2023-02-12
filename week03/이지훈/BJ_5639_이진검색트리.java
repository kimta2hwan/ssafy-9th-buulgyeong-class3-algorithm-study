import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


// 도움! : https://rujang.tistory.com/entry/%EB%B0%B1%EC%A4%80-5639%EB%B2%88-%EC%9D%B4%EC%A7%84-%EA%B2%80%EC%83%89-%ED%8A%B8%EB%A6%AC
//도움을 받았으나 풀지못함.
// 새로운 도움!: https://girawhale.tistory.com/59
// 처음엔 트리를 모두 구성해서 그다음 후위 순회하는걸로 생각했는데 이런 시뮬레이션보단 트리를 이용한 분할정복, 재귀 개념의 문제 같다.
// 분할 정복 개념으로 생각하는게 어렵다.
public class BJ_5639_이진검색트리 {
	static ArrayList<Integer> tree = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("5639.txt")));
		
		String line;
		while((line = br.readLine()) != null) {
			int num = Integer.parseInt(line);
			tree.add(num);
		}
		
		postOrder(0, tree.size()-1);
	}
	
	static void postOrder(int start, int end) {
//		종료조건
		if(start > end)return;

//		다음에 좌,우 자식노드를 재귀로 호출할 구분점. 0으로하면 for문이 바로 끝났을 때 무한루프에 빠져서 end로 초기화.
		int mid = end;
		
		for (int i = start+1; i <= end; i++) {
			if(tree.get(start) < tree.get(i))break;
			mid = i;
		}
		
		postOrder(start+1, mid);
		postOrder(mid+1, end);
		
		System.out.println(tree.get(start));
	}

}

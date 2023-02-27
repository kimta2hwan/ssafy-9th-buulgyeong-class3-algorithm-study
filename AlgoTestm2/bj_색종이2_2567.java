package my.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_색종이2_2567 {

	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static int map[][] = new int [102][102]; //dummy사용, 1번부터 100까지
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st ;
		for(int i=0;i<T;i++) { //상하반대
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());//열이 먼저들어온다
			int r = Integer.parseInt(st.nextToken());

			for(int row=r;row<r+10;row++) {
				for(int col=c;col<c+10;col++) {
					map[row][col] = 1;
				}
			}		
		}
		//상하좌우에 0이 있으면 센다.
		//튀어나온 모서리는 *2번해준다.
		
		int count=0;
		for(int i=0;i<102;i++) {
			for(int j=0;j<102;j++) {
				int num=0;
				if(map[i][j] ==1) {
					for(int k=0;k<4;k++) {
						int row = i+dr[k];
						int col = j+dc[k];
						if(row >=0 && row < 102 && col >=0 && col < 102 && (map[row][col] == 0)) {
							num++;
						}
					}

					if(num >= 1) {
						if(num >=2) {
							count++;
						}
						count++;
					}
				}
			}
		}

		//print();
		System.out.println(count);

	}
	static void print() {
		for(int [] a: map) {
			System.out.println(Arrays.toString(a));
		}
	}

}

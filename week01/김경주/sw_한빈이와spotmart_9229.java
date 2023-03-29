package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_한빈이와spotmart_9229 {

	static int arr[];
	static int N;
	static int M;
	static int ans[] = new int[2];
	static int sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			sum=-1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			System.out.println("#"+test+" "+sum);
			
		}
		
		

	}
	static void comb(int start,int index) {
		if(index == 2) {
			//System.out.println(Arrays.toString(ans));
			int s = arr[ans[0]] +  arr[ans[1]];
			if(s<=M & s>sum) sum = s;
			
			return;
		}
		
		for(int i=start;i<N;i++) {
			ans[index] = i;
			comb(i+1,index+1);
		}
	}

}

// 큐2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P18258 {
	public static int[] q = new int [2000000];
	public static int N;
	public static int s;
	public static int idx;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N =Integer.parseInt(br.readLine());
		
		while(N-- >0) {
			st = new StringTokenizer(br.readLine()," ");
			switch (st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(pop()).append('\n');
				break;
			case "size":
				sb.append(size()).append('\n');
				break;
			case "empty":
				sb.append(empty()).append('\n');
				break;
			case "front":
				sb.append(front()).append('\n');
				break;
			case "back":
				sb.append(back()).append('\n');
				break;

			}
		}
		System.out.println(sb);
	}

	public static void push(int x) {q[s++] = x;	}
	public static int pop() { return s == idx ? -1 : q[idx++];}
	public static int size() { return s-idx;}
	public static int empty() {	return s == idx ? 1 : 0;}
	public static int front() {	return s == idx ? -1 : q[idx];}
	public static int back() { return s == idx ? -1 : q[s-1];}

}

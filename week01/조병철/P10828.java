package algstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10828 {
	public static int[] stack;
	public static int N;
	public static int s;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N =Integer.parseInt(br.readLine());
		stack =new int[N];
		
		while(N-- >0) {
			st = new StringTokenizer(br.readLine()," ");
			switch (st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				System.out.println(pop());
				break;
			case "size":
				System.out.println(size());
				break;
			case "empty":
				System.out.println(empty());
				break;
			case "top":
				System.out.println(top());
				break;

			}
		}
		
	}

	public static void push(int x) {
		stack[s++] = x;
	}

	public static int pop() {
		return s == 0 ? -1 : stack[s-- - 1];

	}

	public static int size() {
		return s;
	}

	public static int empty() {
		return s == 0 ? 1 : 0;
	}

	public static int top() {
		return s == 0 ? -1 : stack[s - 1];
	}

}

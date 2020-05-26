package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {

	static int n;
	static int[] arr,oper;
	static String[] OperList = {"+","-","*","/"};
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		oper = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < 4; i++) {
			if(oper[i] > 0) {
				oper[i]--;
				dfs(1,OperList[i],oper,arr[0]);
				oper[i]++;
			}
		}
		
		System.out.println(max);
		System.out.println(min);
	}
	static private void dfs(int index,String Oper ,int[] oper, int sum) {
		if(Oper.equals("+")) {
			sum += arr[index];
		}
		else if(Oper.equals("-")) {
			sum -= arr[index];
		}
		else if(Oper.equals("*")) {
			sum *= arr[index];
		}
		else if(Oper.equals("/")) {
			sum /= arr[index];
		}
		
		if(index == n-1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 0; i < oper.length; i++) {
			if(oper[i] > 0) {
				oper[i]--;
				dfs(index+1,OperList[i], oper, sum);
				oper[i]++;
			}
		}
	}


}

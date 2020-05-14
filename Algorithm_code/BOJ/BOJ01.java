package BOJ;

import java.util.Scanner;

public class BOJ01 {
	static int x,cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		x = sc.nextInt();
		
		dfs(0);
		System.out.println(cnt);
	}
	
	static void dfs(int sum) {
		if(sum == x) {
			cnt++;
			return;
		}
		else if(sum > x) return;

		
		dfs(sum+1);
		dfs(sum+2);
	}
}

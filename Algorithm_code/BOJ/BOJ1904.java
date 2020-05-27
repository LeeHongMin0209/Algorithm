package BOJ;

import java.util.Scanner;

public class BOJ1904 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		tile(n);
	}
	static void tile(int num) {
		int[] arr = new int[1000001];
		arr[1] = 1;
		arr[2] = 2;
		
		for(int i = 3; i < num + 1; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 15746;
		}
		
		System.out.println(arr[num]);
	}
}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2096 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] dpMax = new int[n+1][4];
		int[][] dpMin = new int[n+1][4];
		int[][] arr = new int[n+1][4];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken()); 
		}
		dpMax[1][1] = dpMin[1][1] = arr[1][1];
		dpMax[1][2] = dpMin[1][2] = arr[1][2];
		dpMax[1][3] = dpMin[1][3] = arr[1][3];
		
		for(int i = 2; i <= n; i++) {
			dpMax[i][1] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + arr[i][1];
			dpMax[i][2] = Math.max(Math.max(dpMax[i-1][1], dpMax[i-1][2]),dpMax[i-1][3]) + arr[i][2];
			dpMax[i][3] = Math.max(dpMax[i-1][2], dpMax[i-1][3]) + arr[i][3];
			
			dpMin[i][1] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + arr[i][1];
			dpMin[i][2] = Math.min(Math.min(dpMin[i-1][1], dpMin[i-1][2]),dpMin[i-1][3]) + arr[i][2];
			dpMin[i][3] = Math.min(dpMin[i-1][2], dpMin[i-1][3]) + arr[i][3];
		}
		
//		for(int i = 1; i <= n; i++) {
//			System.out.println(dpMax[i][1] +" "+ dpMax[i][2] + " "+ dpMax[i][3]);
//		}
		System.out.println(Math.max(Math.max(dpMax[n][1], dpMax[n][2]),dpMax[n][3]) + " " + Math.min(Math.min(dpMin[n][1], dpMin[n][2]),dpMin[n][3]));
	}

}

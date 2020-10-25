package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14719 {
	static int n,m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int[] blockArr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			blockArr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = solution(blockArr, n);
		System.out.println(answer);
	}
	static int solution(int[] blockArr, int x) {
		int answer = 0;
		for(int i = 1; i < x-1; i++) {
			int leftMax = getLeftMax(blockArr, i);
			int rightMax = getRightMax(blockArr, i);
			
			int height = Math.min(leftMax, rightMax);
			if(height > blockArr[i]) {
				answer += height - blockArr[i];
			}
		}
		return answer;
	}
	static int getLeftMax(int[] blockArr, int i) {
		int result = 0;
		for(int idx = i-1; idx >= 0; idx--) {
			result = Math.max(result, blockArr[idx]);
		}
		return result;
	}
	static int getRightMax(int[] blockArr, int i) {
		int result = 0;
		for(int idx = i+1; idx < blockArr.length; idx++) {
			result = Math.max(result, blockArr[idx]);
		}
		return result;
	}
}

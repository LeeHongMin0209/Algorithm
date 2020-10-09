package Programmers;

import java.util.Arrays;

public class numberGame {
	public int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		int aPoint = 0;
		int bPoint = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[aPoint] >= B[bPoint]) {
				bPoint++;
			} else {
				aPoint++;
				bPoint++;
				answer++;
			}
		}
		return answer;
	}
}

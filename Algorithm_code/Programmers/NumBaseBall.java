package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NumBaseBall {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> ans = new ArrayList<>();
		int t = Integer.parseInt(br.readLine());
		int[] numList = new int[t];
		int[] strikeLLsit = new int[t];
		int[] ballList = new int[t];
		
		
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			
			numList[i] = num;
			strikeLLsit[i] = strike;
			ballList[i] = ball;
		}
		
		for(int i = 0; i < t; i ++) {
			
		}
	}
	static void dfs(int num, int strike, int ball) {
		
	}
}

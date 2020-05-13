package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {
	static int t;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> ans = new Stack<>();
		Stack<Integer> s = new Stack<>();
		
		t = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] answer = new int[t];
		
		for(int i = 0; i < t; i++) {
			s.add(Integer.parseInt(st.nextToken()));
		}
		int idx = t - 1;
		while(!s.isEmpty()) {
			Stack<Integer> s2 = new Stack<>();
			int topNum = s.size() - 1;
			int x = s.pop();
			boolean check = false;
			
			
			while(!s.isEmpty()) {
				if(x <= s.peek()) {
					ans.add(topNum);
					check = true;
					break;
				}
				else {
					topNum--;
					s2.add(s.pop());
				}
			}
			while(!s2.isEmpty()) {
				s.add(s2.pop());
			}
			if(!check) ans.add(0);
		}
		ans.pop();
		
		
	}

}

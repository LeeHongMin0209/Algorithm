package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.Stack;

public class BOJ4949 {
	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
	Stack<Character> st = new Stack<>();
	
	while(true) {
		String str = scan.nextLine();
		
		if(str.equals(".")) break;
		
		st.clear();
		boolean run = true;
		for(int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			
			if(ch == '(' || ch == '[') {
				st.push(ch);
			}
			
			else if(ch == ')') {
				if(st.empty() || st.peek() != '(') {
					run = false;
					continue;
				}
				st.pop();
			}
			else if(ch == ']') {
				if(st.empty() || st.peek() != '[') {
					run = false;
					continue;
				}
				st.pop();
			}
		}
		if(!st.empty()) run = false;
		if(run == true) System.out.println("yes");
		else System.out.println("no");
	}
	
	}
	
	
}

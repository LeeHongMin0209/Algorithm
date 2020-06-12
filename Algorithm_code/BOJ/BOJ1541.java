package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strList = br.readLine().split("\\-");
		
		int ans = 0;
		
		for(int i = 0; i < strList.length; i++) {
			int num = calc(strList[i]);
			
			if(i == 0) num *= -1;
			ans -= num;
		}
		System.out.println(ans);
	}
	
	static int calc(String str) {
		String[] sum = str.split("\\+");
		int result = 0;
		for(String s : sum) {
			result += Integer.parseInt(s);
		}
		return result;
	}
}

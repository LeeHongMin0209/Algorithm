package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2011 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int mod = 1000000;
		long[] dp = new long[input.length() + 1];
		dp[0] = dp[1] = 1;
		for(int i = 2; i <= input.length(); i++) {
			int now = i - 1;
			if(input.charAt(now) > '0') dp[i] = dp[i-1];
			int su = (input.charAt(now - 1) - '0') * 10 + (input.charAt(now) - '0');
			if(su >= 10 && su <= 26) dp[i] = (dp[i] + dp[i-2]) % mod;
		}
        if(input.charAt(0) == '0') System.out.print(0);
		else if(input.charAt(input.length()-1) == '0' && input.charAt(input.length()-2) != '1' && input.charAt(input.length()-2) != '2') System.out.print(0);
		else System.out.println(dp[input.length()]);
	}

}

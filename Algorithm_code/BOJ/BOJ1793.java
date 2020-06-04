package BOJ;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ1793 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n;
		BigInteger[] dp = new BigInteger[251];
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");
		
		for(int i = 3; i <= 250; i++) {
			dp[i] = dp[i-2].multiply(new BigInteger("2"));
			dp[i] = dp[i].add(dp[i-1]);
		}
		while(sc.hasNext()) {
			n = sc.nextInt();
			System.out.println(dp[n]);
		}
		 
	}

}


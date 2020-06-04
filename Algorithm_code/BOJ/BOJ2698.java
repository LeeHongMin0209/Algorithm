package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2698 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());

		
		int[][][] dp = new int[101][101][2];
		dp[1][0][0] = 1;
		dp[1][0][1] = 1;
		for(int k = 0; k <= 100; k++) {
			for(int j = 2; j <= 100; j++) {
				if(k == 0) dp[j][k][1] += dp[j-1][k][0];
				else {
					dp[j][k][1] += dp[j-1][k][0] + dp[j-1][k-1][1];							
				}
				dp[j][k][0] += dp[j-1][k][0] + dp[j-1][k][1];
			}	
		}
		
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			int ans = dp[n][z][0] + dp[n][z][1];
			bw.write(String.valueOf(ans)+"\n");
		}
		bw.flush();
		bw.close();
	}

}

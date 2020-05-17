package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2858 {
	static int n,m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int sum = n + m;
		int sqrt = (int)Math.sqrt(sum);
		
		for(int i = 3; i <= sqrt; i++) {
			int j = sum / i;
			
			if(j <= 2) continue;
			
			if(i*j == sum) {
				if(isAns(i,j)) {
					if(i >= j) {
						System.out.println(i + " " + j);
					}
					else {
						System.out.println(j + " " + i);
					}
				}
				
			}
		}

	}
	static boolean isAns(int a, int b) {
		int brown = b - 2;
		int red = a * b;
		
		brown = brown * (a-2);
		red -= brown;
		if(red == n && brown == m) {
			return true;
		}
		return false;
	}
}

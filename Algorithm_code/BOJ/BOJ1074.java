package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
	static int ans,n,r,c;
	static boolean check = true;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int size = (int)Math.pow(2, n);
		func(size, 0, 0);
	}
	static void func(int size, int x, int y) {
		if(size == 1) {
			if(x == r && y == c) System.out.println(ans);
			ans++;
			return;
		
			}	
		func((int)size/2, x, y);
		func((int)size/2, x, y + size/2);
		func((int)size/2, x + size/2, y);
		func((int)size/2, x+size/2, y+size/2);
	}
}

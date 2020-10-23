package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;

public class BOJ2217 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Vector<Integer> vec = new Vector<>();
		for(int i = 0; i < n; i++) {
			vec.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(vec);
		int ans = 0;
		for(int i = 1; i <= n; i++) {
			ans = Math.max(ans, vec.get(n-i)* i);
		}
		System.out.println(ans);
	}

}

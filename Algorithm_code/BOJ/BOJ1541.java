package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] first = str.split("-");
		int ans = 0;
		String[] arr = first[0].split("\\+");
		for(int i = 0; i < arr.length; i++) {
			int tmp = Integer.parseInt(arr[i]);
			ans += tmp;
		}
		
		for(int i = 1; i < first.length; i++) {
			arr = first[i].split("\\+");
			for(int j = 0; j < arr.length; j++) {
				int tmp = Integer.parseInt(arr[j]);
				ans -= tmp;
			}
		}
		System.out.println(ans);
	}
}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1543 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0;
		String document = br.readLine();
		String search = br.readLine();
		for(int i = 0; i <= document.length() - search.length(); i++) {
			if(document.charAt(i) == search.charAt(0)) {
				boolean check = true;
				for(int j = 1; j < search.length(); j++) {
					if(document.charAt(i+j) != search.charAt(j)) {
						check = false;
						break;
					}
				}
				if(check) {
					i += search.length()-1;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

}

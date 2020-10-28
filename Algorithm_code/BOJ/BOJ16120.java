package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16120 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String cmp = "PPAP";
		boolean last = false;
		boolean PPAP = true;
		int one = 0;
		
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == 'P'){
				one++;
				continue; //esle안쓰고 -> 시간 줄이기 위해
			}
			if(i != str.length() - 1) {
				if(one >=2 && str.charAt(i+1) == 'P'){
					one--;
					i++;
				}
				else {
					PPAP = false;
					break;
				}
			} else {
				if(str.charAt(i) == 'P' && str.charAt(i-1) != 'A' || str.charAt(i) == 'A') PPAP = false;
			}
		}
		
		if(one == 1 && PPAP) System.out.println("PPAP");
		else System.out.println("NP");
	}

}

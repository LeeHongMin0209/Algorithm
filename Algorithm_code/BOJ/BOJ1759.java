package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
	static int L,C;
	static char[] arr = new char[15];
	static char[] temp = new char[15];
	static boolean[] visited = new boolean[15];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new char[C];
		for(int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		func(0, 0, 0);
		System.out.println(sb.toString());
	}
	static void func(int k, int moNum, int jaNum) {
		if(k == L && moNum >= 1 && jaNum >= 2) {
			for(int i =0; i < L; i++) {
				sb.append(temp[i]);
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < C; i++) {
			if(!visited[i]) {
				temp[k] = arr[i];
				visited[i] = true;
				if(k == 0) {
					if(moAndJa(temp[k])) func(k + 1, moNum + 1, jaNum);
					else func(k + 1, moNum, jaNum + 1);
				}
				if(k > 0 && (temp[k-1] - 0) < (arr[i] - 0)) {
					if(moAndJa(temp[k])) func(k + 1, moNum + 1, jaNum);
					else func(k + 1, moNum, jaNum + 1);
				}
				visited[i] = false;
			}
		}
	}
	static boolean moAndJa(char ch) {
		if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
		return false;
	}
}

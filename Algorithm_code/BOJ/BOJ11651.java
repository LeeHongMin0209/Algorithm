package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import BOJ.BOJ11650.dot;

public class BOJ11651 {
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dot[] list = new dot[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			dot d = new dot(x, y);
			list[i] = d;
		}
		 Arrays.sort(list, new Comparator<dot>() {
	        	public int compare(dot o1, dot o2) {
	                if(o1.y != o2.y) {
	                	//Double 인수 정렬할때는 다음과 같이
	                    return (o1.y - o2.y);
	                }
	                //int 인수 정렬은 다음과 같이
	                return o1.x - o2.y;
	            }
	        });
		StringBuilder sb =  new StringBuilder();
		for(int i = 0; i < n; i++) {
			int x = list[i].x;
			int y = list[i].y;
			sb.append(x +" "+ y + "\n");
		}
		System.out.println(sb.toString());
	}
}

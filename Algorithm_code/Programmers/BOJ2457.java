package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2457 {
	static class flower implements Comparable<flower>{
		int startD;
		int startM;
		int endD;
		int endM;
		public flower(int startD, int startM, int endD, int endM) {
			this.startD = startD;
			this.startM = startM;
			this.endD = endD;
			this.endM = endM;
		}
		@Override
		public int compareTo(flower f) {
			if(f.startM == this.startM && this.startD == f.startD && f.endM != this.endM) return this.endM - f.endM;
			else if(f.startM == this.startM && this.startD == f.startD) return this.endD - f.endD;
			else if(f.startM == this.startM) return this.startD - f.startD;
			else return this.startM - f.startM;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		ArrayList<flower> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int startM = Integer.parseInt(st.nextToken());
			int startD = Integer.parseInt(st.nextToken());
			int endM = Integer.parseInt(st.nextToken());
			int endD = Integer.parseInt(st.nextToken());
			flower f = new flower(startD, startM, endD, endM);
			list.add(f);
		}
		Collections.sort(list);
		int ans = 0;
		int startIdx = 0;
		
		int endD = 1;
		int endM = 3;
		boolean check = false;
		while(true) {
			for(int i = n-1; i >= startIdx; i--) {
				int startM = list.get(i).startM;
				int startD = list.get(i).startD;
				if(startM < 12) {
					if((startM == endM && startD <= endD) || startM < endM) {
						startIdx = i;
						ans++;
						endM = list.get(i).endM;
						endD = list.get(i).endD;
						check = true;
						break;
					}
				}
			}
			if(!check) {
				ans = 0;
				break;
			}

			if(list.get(startIdx).endM > 11) break;
		}
		
		System.out.println(ans);
	}
}

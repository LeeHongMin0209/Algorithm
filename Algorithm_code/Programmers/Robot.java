package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Robot {
	static class work implements Comparable<work>{
		int si;
		int ei;
		int wi;
		public work(int si, int ei, int wi) {
			this.si = si;
			this.ei = ei;
			this.wi = wi;
		}
		    
		public int getei() {
			return this.ei;
		}
		
		@Override
		public int compareTo(work w) {
			if (this.ei < w.getei()) {
				return -1;
			} else if (this.ei > w.getei()) {
				return 1;
			}
			return 0;
		}		
	}
	
	static int t;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			int num = Integer.parseInt(br.readLine());
			ArrayList<work> list = new ArrayList<>();
			int lastday = 0;
			int totalwork = 0;
			for(int j = 0; j < num; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int si = Integer.parseInt(st.nextToken());
				int ei = Integer.parseInt(st.nextToken());
				int wi = Integer.parseInt(st.nextToken());
				totalwork += wi;
				if(ei > lastday) lastday = ei;
				list.add(new work(si, ei, wi));
			}
			if(isPossible(list, totalwork, lastday)) System.out.println("Yes");
			else System.out.println("No");
		}
	}
	static boolean isPossible(ArrayList<work> list, int totalwork, int lastday) {
		int realWork = 0;
		for(int i = 1; i <= lastday; i++) {
			int robot = 8;
			loop : while(true) {
				ArrayList<work> temp = new ArrayList<>();			
				for(int j = 0; j < list.size(); j++) {
					if(list.get(j).si <= i && list.get(j).wi > 0) {						
						temp.add(list.get(j));
					}
				}
				if(temp.size() == 0) {
					break;
				}
				Collections.sort(temp);
				for(int j = 0; j < temp.size(); j++) {
					if(robot == 0) break loop;
					
					if(temp.get(j).wi >= robot) {
						temp.get(j).wi -= robot;					
						realWork += robot;
						robot = 0;
					}
					else if(temp.get(j).wi < robot){
						
						robot -= temp.get(j).wi;
						realWork += temp.get(j).wi;
						temp.get(j).wi = 0;
					}
				}
			
			}
		}
		if(realWork == totalwork) return true;
		else return false;
	}
}

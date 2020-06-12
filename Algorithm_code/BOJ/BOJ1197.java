package BOJ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1197 {
	static class Ad implements Comparable<Ad>{
		int adVer;
		int w;
		public Ad(int adVer, int w) {
			this.adVer = adVer;
			this.w = w;
		}
		@Override
		public int compareTo(Ad a) {
			return this.w >= a.w ? 1 : -1;
		}
		
	}
	static ArrayList<Ad>[] adList;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		adList = new ArrayList[v+1];
		visited = new boolean[v+1];
		for(int i = 0; i < v+1; i++) {
			adList[i] = new ArrayList<>();
		}
		for(int i = 0; i < e; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weigth = sc.nextInt();
			Ad av = new Ad(end, weigth);
			Ad av2 = new Ad(start, weigth);
			adList[start].add(av);
			adList[end].add(av2);
		}
		
		PriorityQueue<Ad> pq = new PriorityQueue<>();
		visited[1] = true;
		Iterator<Ad> it = adList[1].iterator();
		while(it.hasNext()) {
			pq.offer(it.next());
		}
		int count = 0;
		while(!pq.isEmpty()) {
			Ad pollVertex = pq.poll();
			int ver = pollVertex.adVer;
			if(visited[ver]==true) continue;
			int w = pollVertex.w;
			result += w;
			visited[ver] = true;
			count++;
			if(count==v-1) break;
			ArrayList<Ad> a = adList[ver];
			for(int i = 0; i < a.size(); i++) {
				pq.add(a.get(i));
			}
		}
		System.out.println(result);
	}

}

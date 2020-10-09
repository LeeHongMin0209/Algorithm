package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class longNode {
	public static void main(String[] args) {
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int ans = solution(n, edge);
		System.out.println(ans);
	}
	//런타임에러뜨면 INF값 낮춰보기
	static final int INF = 987654321;
	static int v,e;
	//최단거리 테이블
	static int[] dist;
	//list는 Node List에 대한 List
	static List<List<Node>> list;
	//경로 출력 배열
	static int[] pre = new int[10005];
	//거리와 정점에 대한 pair 생성
	static class Node implements Comparable<Node>{
		int index, distance;
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		 public int compareTo(Node n) {
	            return this.distance - n.distance;
	       }
	}
	static public int solution(int n, int[][] edge) {
		int answer = 0;
		v = n;
		dist = new int[v+5];
		list = new ArrayList<List<Node>>();
		
		list.add(new ArrayList<Node>());
		Arrays.fill(dist, INF);
		for(int i = 1; i <= v; i++) {
			list.add(new ArrayList<Node>());
		}
		for(int i = 0; i < edge.length; i++) {
			int v1 = edge[i][0];
			int v2 = edge[i][1];
			int cost = 1;
			list.get(v1).add(new Node(v2, cost));
			list.get(v2).add(new Node(v1, cost));
		}
		dijkstra(list, dist, 1);
		int max = 0;
		for(int i = 2; i <= n; i++ ) {
			max = Math.max(max, dist[i]);
		}
		for(int i = 2; i <= n; i++) {
			if(dist[i] == max) answer++;
		}
		return answer;
	}
	
	static void dijkstra(List<List<Node>> list, int[] distance, int start) {
		//최소 heap 사용(시간 복잡도 ElogE)
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		distance[start] = 0;
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int idx = cur.index;
			int dist = cur.distance;
			//pq에서 꺼낸 dist와 최단거리 테이블이 일치하지 않으면 넘김(최소거리를 유지하기위해서)
			if(distance[idx] != dist) continue;
			//list에서 idx번째에 해당하는 List<Node>들에 대한 for문(List<Node>들 -> idx에서 갈 수 있는 정점들)
			for(Node nxt : list.get(idx)) {
				int cost = nxt.distance;
				int nidx = nxt.index;
				//idx에서 갈 수 있는 정점들에 대한 최소값 갱신
				if(distance[nidx] > dist + cost) {
					distance[nidx] = dist + cost;
					pq.add(new Node(nidx, distance[nidx]));
					//갱신 될때마다 경로 입력
					pre[nidx] = idx;
				}
			}
		}
	}

}

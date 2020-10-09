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
	//��Ÿ�ӿ����߸� INF�� ���纸��
	static final int INF = 987654321;
	static int v,e;
	//�ִܰŸ� ���̺�
	static int[] dist;
	//list�� Node List�� ���� List
	static List<List<Node>> list;
	//��� ��� �迭
	static int[] pre = new int[10005];
	//�Ÿ��� ������ ���� pair ����
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
		//�ּ� heap ���(�ð� ���⵵ ElogE)
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		distance[start] = 0;
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int idx = cur.index;
			int dist = cur.distance;
			//pq���� ���� dist�� �ִܰŸ� ���̺��� ��ġ���� ������ �ѱ�(�ּҰŸ��� �����ϱ����ؼ�)
			if(distance[idx] != dist) continue;
			//list���� idx��°�� �ش��ϴ� List<Node>�鿡 ���� for��(List<Node>�� -> idx���� �� �� �ִ� ������)
			for(Node nxt : list.get(idx)) {
				int cost = nxt.distance;
				int nidx = nxt.index;
				//idx���� �� �� �ִ� �����鿡 ���� �ּҰ� ����
				if(distance[nidx] > dist + cost) {
					distance[nidx] = dist + cost;
					pq.add(new Node(nidx, distance[nidx]));
					//���� �ɶ����� ��� �Է�
					pre[nidx] = idx;
				}
			}
		}
	}

}
